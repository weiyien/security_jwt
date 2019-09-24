package top.coolidea.security.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.coolidea.security.demo.dao.LaboratoryuserMapper;
import top.coolidea.security.demo.entity.UserInfoView;
import top.coolidea.security.demo.service.LaboratoryUserService;


/**
 * @author: xy_SOA
 * @date: 2019-06-06
 * @description: 用户
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LaboratoryUserServiceImpl implements LaboratoryUserService {
    @Autowired
    private LaboratoryuserMapper laboratoryUserMapper;

    @Override
    public UserInfoView checkUserInfo(String userName) {
        return laboratoryUserMapper.checkUserInfo(userName);
    }

    @Override
    public UserInfoView selectByPrimaryKey(int id) {
        return laboratoryUserMapper.selectByPrimaryKey(id);
    }

}