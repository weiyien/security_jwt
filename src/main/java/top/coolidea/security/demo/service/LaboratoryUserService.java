package top.coolidea.security.demo.service;

import org.springframework.security.access.prepost.PostAuthorize;
import top.coolidea.security.demo.entity.UserInfoView;


/**
 * @author: xy_SOA
 * @date: 2019-06-06
 * @description: 用户
 */

public interface LaboratoryUserService {
    UserInfoView checkUserInfo(String userName);
    @PostAuthorize("returnObject.username==principal.username or hasAuthority('1')")
    UserInfoView selectByPrimaryKey(int id);
}