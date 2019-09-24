package top.coolidea.security.demo.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import top.coolidea.security.demo.error.CommonStatusCode;
import top.coolidea.security.demo.error.ErrorCodeException;

import java.io.IOException;

/**
 * @author: 魏薏恩
 * @date: 2019/3/9 10:52
 * @description:
 */
@Component
public class PassWordUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    private static BASE64Encoder base64Encoder = new BASE64Encoder();
    private static BASE64Decoder base64Decoder = new BASE64Decoder();
    private final static String PREFIX = "kmxykj";

    /**
     * 密码加密
     *
     * @param password 需要加密的密码
     * @return
     */
    public static String encode(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    /**
     * 判断密码是否匹配
     *
     * @param password    需要验证的密码
     * @param aimPassword 正确密码
     * @return
     */
    public static boolean matches(String password, String aimPassword) {
        return bCryptPasswordEncoder.matches(password, aimPassword);
    }

    /**
     * 使用base64加密字符串
     *
     * @param key 需要加密字符串
     * @return 加密字符串结果
     */
    public static String base64encode(String key) {
        return base64Encoder.encodeBuffer((PREFIX + key).getBytes());
    }

    /**
     * 使用base64解密字符串
     *
     * @param key 需要解密的字符串
     * @return 解密结果
     */
    public static String base64decode(String key) {
        byte[] res = null;
        String result = null;
        try {
            res = base64Decoder.decodeBuffer(key);
            result = new String(res);
            result.substring(PREFIX.length());
        } catch (IOException e) {
            throw new ErrorCodeException(CommonStatusCode.SERVER_ERROR, PassWordUtils.class, null);
        }
        return result;
    }
}
