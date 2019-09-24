package top.coolidea.security.demo.filter.security;//package top.coolidea.security.demo.filter.security;
//
//import cn.hutool.core.date.DateUtil;
//import com.alibaba.fastjson.JSON;
//import top.coolidea.security.demo.common.JWTTools;
//import top.coolidea.security.demo.dao.XyUserprofilesMapper;
//import top.coolidea.security.demo.dto.result.ResultDTO;
//import top.coolidea.security.demo.entity.XyUserprofiles;
//import top.coolidea.security.demo.entity.XyUsers;
//import top.coolidea.security.demo.model.ProfileModel;
//import top.coolidea.security.demo.model.UserInfoModel;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author: 魏薏恩
// * @date: 2019/3/4 21:27
// * @description:登录成功时统一结果返回
// */
//@Slf4j
//@Component
//public class XyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
//    @Autowired
//    private JWTTools jwtTools;
//    @Autowired
//    private XyUserprofilesMapper xyUserprofilesMapper;
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
//        XyUsers xyUsers = (XyUsers) authentication.getPrincipal();
//
//        String jwtToken = jwtTools.generatorToken(xyUsers);
//        log.error("LOGINSTATUS:{}", "XyAccessDeniedHandler:" + JSON.toJSONString(xyUsers));
//        UserInfoModel userInfoModel = xyUserConvertToUserInfoModel(xyUsers);
//        XyUserprofiles xyUserprofiles = xyUserprofilesMapper.selectByUserid(xyUsers.getUserid());
//        userInfoModel.setToken(jwtToken);
//        userInfoModel.setProfile(xyUserProfileConvertToProfileModel(xyUserprofiles, xyUsers.getFace()));
//        httpServletResponse.getWriter().write(JSON.toJSONString(ResultDTO.successed(userInfoModel)));
//    }
//
//    /**
//     * entity转viewmodel
//     *
//     * @param xyUsers
//     * @return
//     */
//    private UserInfoModel xyUserConvertToUserInfoModel(XyUsers xyUsers) {
//        UserInfoModel userInfoModel = new UserInfoModel();
//        userInfoModel.setLastLoginTime(DateUtil.formatDateTime(xyUsers.getLastlogintime()));
//        userInfoModel.setRegisteTime(DateUtil.formatDateTime(xyUsers.getRegistetime()));
//        userInfoModel.setUserId(xyUsers.getUserid());
//        userInfoModel.setUserName(xyUsers.getUsername());
//        return userInfoModel;
//    }
//
//    /**
//     * entity转viewmodel
//     *
//     * @param xyUserprofiles
//     * @return
//     */
//    private ProfileModel xyUserProfileConvertToProfileModel(XyUserprofiles xyUserprofiles, String face) {
//        ProfileModel profileModel = new ProfileModel();
//        profileModel.setBirthDay(DateUtil.formatDate(xyUserprofiles.getBirthday()));
//        profileModel.setEmail(xyUserprofiles.getEmail());
//        profileModel.setNickName(xyUserprofiles.getFirstname() + xyUserprofiles.getSecondname());
//        profileModel.setMobile(xyUserprofiles.getMobile());
//        profileModel.setFace(face);
//        profileModel.setProfileId(xyUserprofiles.getUserprofileid());
//        return profileModel;
//    }
//}