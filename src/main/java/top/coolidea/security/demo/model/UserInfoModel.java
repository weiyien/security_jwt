package top.coolidea.security.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author: 魏薏恩
 * @date: 2019/3/8 15:06
 * @description: 登录时使用的视图
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoModel implements BaseModel, Serializable {
    private String cardno;
    private String realname;
    private String userName;
    private Integer userId;
    private String registeTime;
    private Integer identityid;
    private String identityname;
    private Integer usertypeid;
    private String usertype;
    private String token;
    private Integer teacherid;

    @Override
    public Object convert() {
        return null;
    }
}
