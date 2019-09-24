package top.coolidea.security.demo.error;

/**
 * @author: 魏薏恩
 * @date: 2019/2/28 15:43
 * @description: 结果状态代码
 */
public class StatusCode {

    /**
     * 服务器成功返回请求的数据
     */
    public static final Integer SUCCESS = 100200;
    /**
     * 新建或修改数据成功
     */
    public static final Integer UPDATE_SUCCESS = 100201;
    /**
     * 一个请求已经进入后台排队（异步任务）
     */
    public static final Integer WAITING = 100202;
    /**
     * 删除数据成功。
     */
    public static final Integer DELETE_SUCCESS = 100204;
    /**
     * 发出的请求有错误，服务器没有进行新建或修改数据的操作。
     */
    public static final Integer REQUEST_ERROR = 100400;
    /**
     * 用户没有权限（令牌、用户名、密码错误）
     */
    public static final Integer NO_PERMISSION = 100401;
    /**
     * 参数不符合要求
     */
    public static final Integer PARAM_ILLEGAL = 100402;
    /**
     * 用户得到授权，但是访问是被禁止的。
     */
    public static final Integer FORBIDEN = 100403;
    /**
     * 发出的请求针对的是不存在的记录，服务器没有进行操作
     */
    public static final Integer NO_DATA = 100404;
    /**
     * 请求的格式不可得
     */
    public static final Integer BAD_FORMAT = 100406;
    /**
     * 请求的资源被永久删除，且不会再得到的
     */
    public static final Integer EXPIRED_DATA = 100410;
    /**
     * 当创建一个对象时，发生一个验证错误
     */
    public static final Integer CREATE_OBJ_ERROR = 100422;
    /**
     * 服务器发生错误，请检查服务器
     */
    public static final Integer SERVER_ERROR = 100500;
    /**
     * '网关错误。'
     */
    public static final Integer GETEWAY_ERROR = 100502;
    /**
     * '服务不可用，服务器暂时过载或维护。'
     */
    public static final Integer OVER_LOAD = 100503;
    /**
     * '网关超时。'
     */
    public static final Integer TIMEOUT = 100504;
    /**
     * 错误的用户名或密码
     */
    public static final Integer LOGIN_PARAM_ERROR = 100001;
    /**
     * 当前用户不存在
     */
    public static final Integer LOGIN_NO_USER = 100002;
    /**
     * 不具备当前系统登陆权限
     */
    public static final Integer LOGIN_NO_AUTH = 100003;
    /**
     * 当前系统暂停使用
     */
    public static final Integer LOGIN_APP_ERROR = 100004;
    /**
     * 当前用户暂停使用
     */
    public static final Integer LOGIN_COUNT_PAUSE = 100005;
    /**
     * 当前用户没有激活
     */
    public static final Integer LOGIN_COUNT_NOT_ACTIVE = 100006;
    /**
     * 当前用户已停用
     */
    public static final Integer LOGIN_COUNT_NOT_EXPIRED = 100007;
    /**
     * 用户已存在
     */
    public static final Integer USEREXIST = 100008;
    /**
     * 登录失败
     */
    public static final Integer LOGIN_FAILD = 100099;
    /**
     * token失效
     */
    public static final Integer TOKEN_EXPIRED = 100009;
    /**
     * 短信验证码错误
     */
    public static final Integer ERROR_SMS_CODE = 100433;
    /**
     * 所选时间不开放预定
     */
    public static final Integer TIME_NOT_OPEN = 110001;
    /**
     * 所选时间已经被预定
     */
    public static final Integer TIME_REPEAT_ORDER = 110002;
    /**
     * 所选时间不连续
     */
    public static final Integer TIME_NOT_CONTINUE = 110003;
    /**
     * 没有选择时间
     */
    public static final Integer TIME_NOT_SELECT = 110004;
    /**
     * 设备所在实验室不开放
     */
    public static final Integer LAB_NOT_OPEN = 110005;
    /**
     * 客户端ip非内网网段
     */
    public static final Integer IP_NOT_OPEN = 110006;
    /**
     * 设备未设置关联电脑或者实验室
     */
    public static final Integer INSTRUMENT_NOT_COMPLETE = 110007;
    /**
     * 文件夹容量不足
     */
    public static final Integer CAPACITY_NOT_ENOUGH = 110008;
    /**
     * 文件不存在
     */
    public static final Integer FILE_NOT_EXIST = 110009;
    /**
     * 数据重复
     */
    public static final Integer REPEAT_DATA = 110010;

    /**
     * 号码格式不正确
     */
    public static final Integer INCORRECT_PHONE_NUMBER = 110011;

    /**
     * 密码格式不正确
     */
    public static final Integer INCORRECT_PASSWORD_FORMAT = 110012;

    /**
     * 邮件格式不正确
     */
    public static final Integer INCORRECT_EMAIL_FORMAT = 110013;

    /**
     * 身份证格式不正确
     */
    public static final Integer INCORRECT_IDCARD_NUMBER = 110014;

    /**
     * 所选时间有其他预定
     */
    public static final Integer USER_REPEAT_ORDER = 110015;

    /**
     * 旧密码错误
     */
    public static final Integer OLDPASSWORD_ERROR = 110016;
    /**
     * 学生号格式错误
     */
    public static final Integer INCORRECT_CARD_NUMBER = 110017;

    /**
     * 全是数字错误
     */
    public static final Integer NOT_ALL_NUMBER = 110018;

    /**
     * ip地址错误
     */
    public static final Integer IP_ADDRESS_ERROR = 110019;
    /**
     * 校园卡多次绑定
     */
    public static final Integer CARDNOEXIST = 110020;

    /**
     * 邮箱不存在
     */
    public static final Integer EMAIL_NOT_EXIST = 110021;
    /**
     * 订单号重复
     */
    public static final Integer REGNUMBER_REPEAT = 110022;
    /**
     * 邮箱已经存在
     */
    public static final Integer EMAIL_REPEAT = 110023;
    /**
     * 手机号码已经存在
     */
    public static final Integer PHONE_REPEAT = 110024;
    /**
     * 承诺人签名和当前用户不匹配
     */
    public static final Integer SIGN_ILLEGAL = 110025;
    /**
     * 导师不匹配
     */
    public static final Integer ERROR_TEACHER = 110026;
}
