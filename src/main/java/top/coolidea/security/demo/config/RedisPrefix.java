package top.coolidea.security.demo.config;

/**
 * @author: 魏薏恩
 * @date: 2019/3/5 15:57
 * @description: redis前缀
 */
public class RedisPrefix {
    /**
     * REDIS 用户权限信息前缀
     */
    public static final String USER_OPERS_PREFIX = "USER_OPERS_";
    /**
     * REDIS 用户token信息前缀
     */
    public static final String USER_TOKEN_PREFIX = "USER_TOKEN_";
    /**
     * REDIS 用户详细信息前缀
     */
    public static final String USER_DETAIL_PREFIX = "USER_DETAIL_";
    /**
     * 所有域的信息
     */
    public static final String DOMAIN_STATISTIC = "DOMAIN_STATISTIC";
    /**
     * 应用程序密钥信息
     */
    public static final String APP_SECRET = "APP_SEC_";
    /**
     * 存储当前登录的用户token
     */
    public static final String APP_ONLINE_USER = "APP_ONLINE_USER_";
    /**
     * 存储当前登录的用户前后端跳转数量
     */
    public static final String APP_ONLINE_DIRECT_USER = "APP_ONLINE_DIRECT_USER_";
    /**
     * 用户详细信息
     */
    public static final String DETAIL_USER_INFO = "DETAIL_USER_INFO_";
    /**
     * 短信验证码前缀
     */
    public static final String USER_SMS_CODE = "USER_SMS_CODE_";
    /**
     * jwt公钥私钥
     */
    public static final String JWT_PUBLIC_KEY = "JWT_PUBLIC_KEY_";
    /**
     * jwt私钥
     */
    public static final String JWT_PRIVATE_KEY = "JWT_PRIVATE_KEY_";
    /**
     * 邮箱验证码
     */
    public static final String EMAIL_CODE = "EMAIL_CODE_";

    /**
     * 重置密码验证
     */
    public static final String RESET_PASSWORD = "RESET_PASSWORD_";
    /**
     * 控制门禁
     */
    public static final String HIKDOORLIST = "HIK_DOOR_LIST";
    /**
     * 网站首页缓存
     */
    public static final String CONTENTINDEX = "CONTENT_INDEX_";
    /**
     * 首页链接
     */
    public static final String TITLELINK = "TITLELINK";
    /**
     * 首页图片
     */
    public static final String IMAGEINDEX = "IMAGEINDEX";
    /**
     * 首页友情链接
     */
    public static final String LINKINDEX = "LINKINDEX";
    /**
     * 首页菜单
     */
    public static final String TITLEINDEX = "TITLEINDEX";
    /**
     * 用户权限
     */
    public static final String USER_AUTHORITIES = "USER_AUTHORITIES";
}
