package top.coolidea.security.demo.common;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author: 魏薏恩
 * @date: 2019/3/19 14:13
 * @description: MD5加密工具类
 */
@Component
public class MD5Utils {
    /**
     * 可以把一段文字转换为MD
     * Can convert a file to MD5
     *
     * @param text 需要加密字符串
     * @return md5
     */
    public static String encode(String text) {
        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] buffer = digest.digest(text.getBytes());
            // byte -128 ---- 127
            StringBuffer sb = getHashResult(buffer);
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


    /***
     * 任意文件转换成Md5
     * Can convert a text to MD5
     * @param inputStream
     * @return md5
     */

    public static String encode(InputStream in) {
        try {
            MessageDigest digester = MessageDigest.getInstance("MD5");
            byte[] bytes = new byte[8192];
            int byteCount;
            while ((byteCount = in.read(bytes)) > 0) {
                digester.update(bytes, 0, byteCount);
            }
            byte[] digest = digester.digest();
            StringBuffer sb = getHashResult(digest);
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 计算byte数组的hash值
     *
     * @param buffer
     * @return
     */
    private static StringBuffer getHashResult(byte[] buffer) {
        StringBuffer sb = new StringBuffer();
        for (byte b : buffer) {
            int a = b & 0xff;
            String hex = Integer.toHexString(a);
            if (hex.length() == 1) {
                hex = 0 + hex;
            }
            sb.append(hex);
        }
        return sb;
    }
}
