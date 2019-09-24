package top.coolidea.security.demo.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author: 魏薏恩
 * @date: 2019/3/8 15:12
 * @description:
 */
@Data
public class LoginModel implements BaseModel, Serializable {
    @NotNull
    private String username;
    @NotNull
    private String password;
    /**
     * 前台 后台
     */
    private String apptype;

    @Override
    public Object convert() {
        return null;
    }
}
