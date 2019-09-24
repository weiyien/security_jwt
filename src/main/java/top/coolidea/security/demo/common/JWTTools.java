package top.coolidea.security.demo.common;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.coolidea.security.demo.config.RedisPrefix;
import top.coolidea.security.demo.entity.UserInfoView;

import java.security.Key;
import java.security.interfaces.RSAPrivateKey;
import java.util.Date;
import java.util.Map;

/**
 * @author: 魏薏恩
 * @date: 2019/3/19 14:13
 * @description: JWT验证工具类
 */
@Slf4j
@Data
@Component
public class JWTTools {

    /**
     * 应用程序名,用来获取应用程序加密信息
     */
    private String name;
    /**
     * token前缀
     */
    private String prefix = "Bearer ";
    /**
     * 有效时间
     */
    private long ttl = 60 * 60 * 1000 * 24;
    @Autowired
    private KeyUtils keyUtils;
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 生成基于HMAC SHA256的Token
     * 默认过期：20分钟
     * [
     * 此处被认为后期需要添加Application Domain认证机制
     * ]
     * * @param subject （主体信息）
     * * @param expirationSeconds 过期时间（秒）
     * * @param claims 自定义身份信息
     *
     * @param user 用户信息
     * @return token字符串
     */
    public String generatorToken(UserInfoView user) {
        Object redisKey = redisUtils.getBaseObjectValue(RedisPrefix.JWT_PRIVATE_KEY);
        if (redisKey == null) {
            keyUtils.generateKey();
            redisKey = redisUtils.getBaseObjectValue(RedisPrefix.JWT_PRIVATE_KEY);
        }
        RSAPrivateKey privateKey = (RSAPrivateKey) redisKey;
        String authToken = Jwts.builder()
                .setId(user.getUserid() + "")
                .setSubject(user.getUsername() + "")
                .setExpiration(new Date(System.currentTimeMillis() + ttl))
                .signWith(SignatureAlgorithm.RS256, privateKey)
                .claim("auth",user.getRole())
                // 不使用公钥私钥 secret
                //.signWith(SignatureAlgorithm.RS256, privateKey)
                .compact();
        return authToken;
    }

    /**
     * 解析token, 获得subject中的信息
     *
     * @param token token字符串
     * @return subject中的信息
     */
    public String parseToken(String token) {
        String subject = null;
        try {
            subject = getTokenBody(token).getSubject();
        } catch (Exception e) {
        }
        return subject;
    }

    /**
     * 获取token自定义属性
     *
     * @param token token字符串
     * @return token自定义属性
     */
    public Map<String, Object> getClaims(String token) {
        Map<String, Object> claims = null;
        try {
            claims = getTokenBody(token);
        } catch (Exception e) {
        }

        return claims;
    }

    /**
     * 是否已过期
     *
     * @param token token字符串
     * @return
     */
    public boolean isExpiration(String token) {
        try {
            log.error("过期时间{}", getTokenBody(token).getExpiration());
            log.error("当前时间{}", new Date());
            log.error("验证状态{}", getTokenBody(token).getExpiration().before(new Date()));
            return getTokenBody(token).getExpiration().before(new Date());
        } catch (Exception e) {
            return true;
        }
    }

    /**
     * 获取token body中存放的信息
     *
     * @param token token字符串
     * @return body中存放的信息
     */
    public Claims getTokenBody(String token) {
        // 获取系统公钥,如果找不到(过期,数据缺失)重新生成.
        Object redisKey = redisUtils.getBaseObjectValue(RedisPrefix.JWT_PUBLIC_KEY);
        if (redisKey == null) {
            keyUtils.generateKey();
            redisKey = redisUtils.getBaseObjectValue(RedisPrefix.JWT_PUBLIC_KEY);
        }
        Key publicKey = (Key) redisKey;
        token.substring(prefix.length());
        return Jwts.parser()
                // 使用公钥签名
                .setSigningKey(publicKey)
                .parseClaimsJws(token)
                .getBody();
    }
}
