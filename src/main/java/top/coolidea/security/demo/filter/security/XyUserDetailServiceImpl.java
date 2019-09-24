package top.coolidea.security.demo.filter.security;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import top.coolidea.security.demo.common.RedisUtils;
import top.coolidea.security.demo.config.RedisPrefix;
import top.coolidea.security.demo.dao.LaboratoryuserMapper;
import top.coolidea.security.demo.entity.LaboratoryUser;
import top.coolidea.security.demo.error.CommonStatusCode;
import top.coolidea.security.demo.error.ErrorCodeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


/**
 * @author: 魏薏恩
 * @date: 2019/3/4 14:40
 * @description:
 */
@Slf4j
@Service
public class XyUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private LaboratoryuserMapper laboratoryUserMapper;


    /**
     * 首先从redis中根据用户名获取用户数据,找到匹配数据直接返回
     * 找不到用户数据到数据库查询
     * 查询到存到redis中,返回用户信息
     *
     * @param username
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        LaboratoryUser laboratoryUser = getRedisUserDetail(username);
        if (laboratoryUser != null) {
            return laboratoryUser;
        }
        List<LaboratoryUser> userList = laboratoryUserMapper.getUserInfoForJWT(username);
        if (userList == null || userList.size() == 0) {
            throw new ErrorCodeException(CommonStatusCode.NO_PERMISSION, this.getClass(), null);

        }
        LaboratoryUser user = userList.get(0);
        if (user == null || user.getUserid() == null) {
            throw new ErrorCodeException(CommonStatusCode.NO_PERMISSION, this.getClass(), null);
        }
        List<GrantedAuthority> authoritiesSet = new ArrayList<>();
        // 模拟从数据库中获取用户角色
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getIdentityid() + "");
        authoritiesSet.add(authority);
        user.setAuthorities(authoritiesSet);
        user.setRoles(user.getIdentityid()+"");
        setRedisUserDetail(user);
        return user;
    }

    /**
     * userdetail信息存入redis,默认有效时间40分钟(token有效期20分钟)
     *
     * @param user
     */
    private void setRedisUserDetail(LaboratoryUser user) {
        log.error("USERJSON:{}", JSON.toJSONString(user));
        redisUtils.setValue(RedisPrefix.USER_DETAIL_PREFIX + user.getUsername(), JSON.toJSONString(user), (long) 40, TimeUnit.MINUTES);
    }

    /**
     * 根据用户名从redis中获取用户数据
     *
     * @param username
     * @return
     */
    private LaboratoryUser getRedisUserDetail(String username) {
        String userString = redisUtils.getValue(RedisPrefix.USER_DETAIL_PREFIX + username);
        log.error("USERJSON:{}", userString);
        if (StrUtil.isEmpty(userString)) {
            return null;
        } else {
            LaboratoryUser laboratoryUser = JSON.parseObject(userString, LaboratoryUser.class);
            Collection<? extends GrantedAuthority> authorities =
                    Arrays.stream(laboratoryUser.getRoles().split(","))
                            .map(SimpleGrantedAuthority::new)
                            .collect(Collectors.toList());
            laboratoryUser.setAuthorities(authorities);
            return laboratoryUser;
        }
    }

}
