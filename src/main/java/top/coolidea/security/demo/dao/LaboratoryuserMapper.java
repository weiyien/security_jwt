package top.coolidea.security.demo.dao;

import top.coolidea.security.demo.entity.*;

import java.util.List;

/**
 * @author: xy_SOA
 * @date: 2019-06-06
 * @description: 用户
 */

public interface LaboratoryuserMapper {
    List<LaboratoryUser> getUserInfoForJWT(String username);

    UserInfoView checkUserInfo(String userName);

    UserInfoView selectByPrimaryKey(int id);
}