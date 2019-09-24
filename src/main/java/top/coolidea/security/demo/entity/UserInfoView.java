package top.coolidea.security.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: 魏薏恩
 * @date: 2019/3/9 13:45
 * @description: 用户信息view
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoView {
    private Integer userid;
    private String username;
    private String password;
    private Date registetime;
    private Boolean alowable;
    private String remark;
    private String remark2;
    private Integer userprofileid;
    private String realname;
    private Boolean gender;
    private String cardno;
    private String idcardno;
    private String mobile;
    private String email;
    private Integer identityid;
    private String identityname;
    private Integer usertypeid;
    private String usertype;
    private String registetimeStr;
    private Integer teacherid;
    private Date expireTime;
    private Integer groupId;
    private Integer groupuserid;
    private String company;
    private String studentno;
    private String role;
}
