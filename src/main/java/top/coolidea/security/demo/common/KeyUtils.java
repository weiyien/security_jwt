package top.coolidea.security.demo.common;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.coolidea.security.demo.config.RedisPrefix;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * @author: 魏薏恩
 * @date: 2019/5/7 15:58
 * @description: 用于生成公钥和私钥
 */
@Component
public class KeyUtils {
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 创建公钥私钥,公钥存入redis,私钥存入数据库并返回
     */
    public Key generateKey() {
        //创建公钥私钥
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
        redisUtils.setValue(RedisPrefix.JWT_PUBLIC_KEY, rsaPublicKey);
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
        redisUtils.setValue(RedisPrefix.JWT_PRIVATE_KEY, rsaPrivateKey);
        return rsaPrivateKey;
    }
}
