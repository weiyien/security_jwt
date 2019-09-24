package top.coolidea.security.demo.result;

import lombok.Data;
import top.coolidea.security.demo.error.CommonStatusCode;

/**
 * @author: 魏薏恩
 * @date: 2019/2/28 15:43
 * @description: 统一返回类型
 */
@Data
public class ResultDTO {

    /**
     * 执行成功状态
     */
    private boolean success;
    /**
     * 执行状态代码
     */
    private Integer errorCode;
    /**
     * 错误信息
     */
    private String message;
    /**
     * 执行成功返回的数据
     */
    private Object data;

    public ResultDTO() {
    }

    public ResultDTO(boolean success, Integer errorCode, String message, Object data) {
        this.success = success;
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功执行
     *
     * @param data 需要返回的数据
     * @return
     */

    public static ResultDTO successed(Object data) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setSuccess(true);
        resultDTO.setData(data);
        resultDTO.setMessage(CommonStatusCode.SUCCESS.getMessage());
        resultDTO.setErrorCode(0);
        return resultDTO;
    }

    /**
     * 执行失败
     *
     * @param errorMessage 错误信息
     * @param code         错误代码
     * @return
     */
    public static ResultDTO failed(String errorMessage, Integer code) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setSuccess(false);
        resultDTO.setData(null);
        resultDTO.setMessage(errorMessage);
        resultDTO.setErrorCode(code);
        return resultDTO;
    }

    /**
     * 执行失败
     *
     * @param commonStatusCode 自定义状态信息
     * @return
     */
    public static ResultDTO failed(CommonStatusCode commonStatusCode) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setSuccess(false);
        resultDTO.setData(null);
        resultDTO.setMessage(commonStatusCode.getMessage());
        resultDTO.setErrorCode(commonStatusCode.getCode());
        return resultDTO;
    }
}
