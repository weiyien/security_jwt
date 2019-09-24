package top.coolidea.security.demo.error;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: weiyien
 * @date: 2019/2/28 15:43
 * @description: 自定义异常
 */
public class ErrorCodeException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    /**
     * 异常代码
     */
    @Setter
    @Getter
    private Integer code;
    /**
     * 异常描述信息
     */
    @Setter
    @Getter
    private String message;
    /**
     * 发生异常的类信息
     */
    private Class clazz;
    /**
     * 其他信息
     */
    @Getter
    private List<String> params;

    /**
     * 改用带Class的抛出方式
     *
     * @param commonStatusCode
     */
    @Deprecated
    public ErrorCodeException(CommonStatusCode commonStatusCode) {
        this.code = commonStatusCode.getCode();
        this.message = commonStatusCode.getMessage();
    }


    public ErrorCodeException(CommonStatusCode commonStatusCode, Class clazz, List<Object> params) {
        this.code = commonStatusCode.getCode();
        this.clazz = clazz;
        this.message = commonStatusCode.getMessage();
        if (params != null && params.size() > 0) {
            List<String> paramString = params.stream().map(Object::toString).collect(Collectors.toList());
            this.params = paramString;
        }
    }

    @Override
    public String toString() {
        String res = "ErrorCodeException{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", ClassName='" + clazz.getName() + '\'';
        if (params != null && params.size() > 0) {
            res += ", params='" + params.toString() + '\'';
        }
        res += '}';
        return res;
    }
}
