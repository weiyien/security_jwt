package top.coolidea.security.demo.error;


/**
 * @author: 魏薏恩
 * @date: 2019/2/28 15:43
 * @description: 自定义状态
 */
public enum CommonStatusCode {
    SUCCESS(StatusCode.SUCCESS, "操作成功"),
    UPDATE_SUCCESS(StatusCode.UPDATE_SUCCESS, "新建或修改数据成功"),
    WAITING(StatusCode.WAITING, "一个请求已经进入后台排队（异步任务） "),
    DELETE_SUCCESS(StatusCode.DELETE_SUCCESS, "删除数据成功"),
    REQUEST_ERROR(StatusCode.REQUEST_ERROR, "发出的请求有错误，服务器没有进行新建或修改数据的操作"),
    NO_PERMISSION(StatusCode.NO_PERMISSION, "用户没有权限或者TOKEN已经过期"),
    FORBIDEN(StatusCode.FORBIDEN, "用户得到授权，但是访问是被禁止的"),
    NO_DATA(StatusCode.NO_DATA, "发出的请求针对的是不存在的记录，服务器没有进行操作"),
    BAD_FORMAT(StatusCode.BAD_FORMAT, "请求的格式不可得"),
    EXPIRED_DATA(StatusCode.EXPIRED_DATA, "请求的资源被永久删除，且不会再得到的"),
    CREATE_OBJ_ERROR(StatusCode.CREATE_OBJ_ERROR, "后当创建一个对象时，发生一个验证错误"),
    SERVER_ERROR(StatusCode.SERVER_ERROR, "服务器发生错误，请检查服务器"),
    GETEWAY_ERROR(StatusCode.GETEWAY_ERROR, "网关错误"),
    OVER_LOAD(StatusCode.OVER_LOAD, "服务不可用，服务器暂时过载或维护"),
    TIMEOUT(StatusCode.TIMEOUT, "网关超时"),
    PARAM_ILLEGAL(StatusCode.PARAM_ILLEGAL, "参数不符合要求"),
    LOGIN_PARAM_ERROR(StatusCode.LOGIN_PARAM_ERROR, "错误的用户名或密码"),
    LOGIN_NO_USER(StatusCode.LOGIN_NO_USER, "当前用户不存在"),
    LOGIN_NO_AUTH(StatusCode.LOGIN_NO_AUTH, "不具备当前系统登陆权限"),
    LOGIN_APP_ERROR(StatusCode.LOGIN_APP_ERROR, "当前系统暂停使用"),
    LOGIN_COUNT_PAUSE(StatusCode.LOGIN_COUNT_PAUSE, "当前用户暂停使用"),
    LOGIN_COUNT_NOT_ACTIVE(StatusCode.LOGIN_COUNT_NOT_ACTIVE, "当前用户没有激活"),
    LOGIN_COUNT_NOT_EXPIRED(StatusCode.LOGIN_COUNT_NOT_EXPIRED, "当前用户已停用"),
    USEREXIST(StatusCode.USEREXIST, "此用户已经存在"),
    CARDNOEXIST(StatusCode.CARDNOEXIST, "此校园卡号已有其他账户绑定"),
    LOGIN_FAILD(StatusCode.LOGIN_FAILD, "未知错误导致登录失败"),
    TOKEN_EXPIRED(StatusCode.TOKEN_EXPIRED, "TOKEN已经失效"),
    ERROR_SMS_CODE(StatusCode.ERROR_SMS_CODE, "错误的短信验证码"),
    TIME_NOT_OPEN(StatusCode.TIME_NOT_OPEN, "当前所选时间段不开放预定,请修改预约时间段"),
    TIME_REPEAT_ORDER(StatusCode.TIME_REPEAT_ORDER, "所选时间段已被他人先一步预约成功,请修改预约时间"),
    USER_REPEAT_ORDER(StatusCode.USER_REPEAT_ORDER, "已有其他预约占用当前所选的时间段,请修改预约时间"),
    TIME_NOT_CONTINUE(StatusCode.TIME_NOT_CONTINUE, "预约的时间段是不连续的,发起预约失败.请修改预约时间"),
    LAB_NOT_OPEN(StatusCode.LAB_NOT_OPEN, "设备所在实验室不开放预定,请联系管理员"),
    TIME_NOT_SELECT(StatusCode.TIME_NOT_SELECT, "未选择需要预约的时间段,发起预约失败.请修改预约时间"),
    REGNUMBER_REPEAT(StatusCode.REGNUMBER_REPEAT, "预约订单号重复,请重新发起申请"),
    IP_NOT_OPEN(StatusCode.IP_NOT_OPEN, "客户端ip非内网网段"),
    INSTRUMENT_NOT_COMPLETE(StatusCode.INSTRUMENT_NOT_COMPLETE, "仪器所属实验室或配套电脑未设置"),
    CAPACITY_NOT_ENOUGH(StatusCode.CAPACITY_NOT_ENOUGH, "文件夹容量不足"),
    FILE_NOT_EXIST(StatusCode.FILE_NOT_EXIST, "文件不存在"),
    REPEAT_DATA(StatusCode.REPEAT_DATA, "数据已经存在"),
    INCORRECT_PHONE_NUMBER(StatusCode.INCORRECT_PHONE_NUMBER, "号码格式不正确"),
    INCORRECT_PASSWORD_FORMAT(StatusCode.INCORRECT_PASSWORD_FORMAT, "密码格式不正确"),
    INCORRECT_EMAIL_FORMAT(StatusCode.INCORRECT_EMAIL_FORMAT, "邮件格式不正确"),
    INCORRECT_IDCARD_NUMBER(StatusCode.INCORRECT_IDCARD_NUMBER, "身份证格式不正确"),
    INCORRECT_CARD_NUMBER(StatusCode.INCORRECT_CARD_NUMBER, "卡号格式不正确"),
    OLDPASSWORD_ERROR(StatusCode.OLDPASSWORD_ERROR, "旧密码错误"),
    NOT_ALL_NUMBER(StatusCode.NOT_ALL_NUMBER, "不能全是数字,至少十位"),
    IP_ADDRESS_ERROR(StatusCode.IP_ADDRESS_ERROR, "IP地址不正确"),
    EMAIL_REPEAT(StatusCode.EMAIL_REPEAT, "邮箱已被使用"),
    PHONE_REPEAT(StatusCode.PHONE_REPEAT, "手机号已被使用"),
    EMAIL_NOT_EXIST(StatusCode.EMAIL_NOT_EXIST, "该邮件不存在"),
    SIGN_ILLEGAL(StatusCode.SIGN_ILLEGAL, "承诺人和当前用户不匹配,请重新输入"),
    ERROR_TEACHER(StatusCode.ERROR_TEACHER, "所选导师和当前用户导师不匹配,请重新输入"),
    ;
//
    /**
     * 错误状态码
     */
    private Integer code;
    /**
     * 错误信息
     */
    private String message;


    CommonStatusCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
