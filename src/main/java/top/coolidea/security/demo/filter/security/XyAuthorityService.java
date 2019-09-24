package top.coolidea.security.demo.filter.security;

import top.coolidea.security.demo.common.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: 魏薏恩
 * @date: 2019/3/4 21:30
 * @description:自定义权限过滤
 */
@Component("xyauthorityservice")
public class XyAuthorityService {
    @Autowired
    private RedisUtils redisUtils;

    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {

        Object userInfo = authentication.getPrincipal();

        boolean hasPermission = false;
        if (userInfo == null) {
            return false;
        }
        if (userInfo instanceof UserDetails) {

//            String username = ((UserDetails) userInfo).getUsername();
//            List<XyUserOpersView> opersViewList = getUserOpersByUsername(username);
//            setUserOpersToRedis(username, opersViewList);
//            //获取资源
//            Set<String> urls = new HashSet();
//            // 这些 url 都是要登录后才能访问，且其他的 url 都不能访问！
//            urls.add("/demo/**");//
//            Set set2 = new HashSet();
//            Set set3 = new HashSet();
//
//            AntPathMatcher antPathMatcher = new AntPathMatcher();
//
//            for (String url : urls) {
//                if (antPathMatcher.match(url, request.getRequestURI())) {
//                    hasPermission = true;
//                    break;
//                }
//            }
//            return hasPermission;
            return true;
        } else {
            return false;
        }
    }
}