package top.coolidea.security.demo.filter;


import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.filter.OncePerRequestFilter;
import top.coolidea.security.demo.common.JWTTools;
import top.coolidea.security.demo.common.MD5Utils;
import top.coolidea.security.demo.common.RedisUtils;
import top.coolidea.security.demo.config.RedisPrefix;
import top.coolidea.security.demo.error.CommonStatusCode;
import top.coolidea.security.demo.filter.security.XyUserDetailServiceImpl;
import top.coolidea.security.demo.result.ResultDTO;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author: 魏薏恩
 * @date: 2019/3/4 21:41
 * @description: Authorization过滤, 有token时request中存放用户相关信息
 */
@Slf4j
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private XyUserDetailServiceImpl userDetailsService;
    @Autowired
    private JWTTools jwtTools;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        if (request.getMethod().equals(RequestMethod.OPTIONS.name())) {
            filterChain.doFilter(request, response);
        }
        if (authHeader != null && authHeader.startsWith(jwtTools.getPrefix())) {
            String authToken = authHeader.substring(jwtTools.getPrefix().length());
            if (jwtTools.isExpiration(authToken)) {
                response.getWriter().write(JSON.toJSONString(ResultDTO.failed(CommonStatusCode.TOKEN_EXPIRED)));
                return;
            }
            Claims claims = jwtTools.getTokenBody(authToken);
            Integer userid = Integer.parseInt(claims.getId());
            String username = claims.getSubject();
            System.out.println(SecurityContextHolder.getContext().getAuthentication());
            if (userid != null) {
//                验证token是否是最新签发的
                //            验证token有效期
                if (!validRedisToken(userid, authToken)) {
                    response.getWriter().write(JSON.toJSONString(ResultDTO.failed(CommonStatusCode.TOKEN_EXPIRED)));
                    return;
                }
                updateRedisTokenExpiration(userid, authToken);
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                System.out.println(userDetails.toString());
                if (userDetails != null) {
                    request.setAttribute("userid", userid);
                    request.setAttribute("username", username);
                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        filterChain.doFilter(request, response);
    }

    private void updateRedisTokenExpiration(Integer userid, String authToken) {
        redisUtils.setValue(RedisPrefix.APP_ONLINE_USER + userid, MD5Utils.encode(authToken), (long) 24, TimeUnit.HOURS);
        redisUtils.expire(RedisPrefix.DETAIL_USER_INFO + userid, (long) 24, TimeUnit.HOURS);
    }

    private boolean validRedisToken(Integer userid, String authToken) {
        //                验证token是否是最新签发的
        String md5RedisToken = redisUtils.getValue(RedisPrefix.APP_ONLINE_USER + userid);
        String md5HeaderToken = MD5Utils.encode(authToken);
        if (StrUtil.isEmpty(md5RedisToken) || !md5RedisToken.equals(md5HeaderToken)) {
            return false;
        }
        return true;
    }
}