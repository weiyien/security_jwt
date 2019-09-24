package top.coolidea.security.demo.controller;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.coolidea.security.demo.common.JWTTools;
import top.coolidea.security.demo.common.MD5Utils;
import top.coolidea.security.demo.common.PassWordUtils;
import top.coolidea.security.demo.config.RedisPrefix;
import top.coolidea.security.demo.entity.UserInfoView;
import top.coolidea.security.demo.error.CommonStatusCode;
import top.coolidea.security.demo.filter.security.XyUserDetailServiceImpl;
import top.coolidea.security.demo.model.LoginModel;
import top.coolidea.security.demo.model.UserInfoModel;
import top.coolidea.security.demo.result.ResultDTO;
import top.coolidea.security.demo.service.LaboratoryUserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.concurrent.TimeUnit;

/**
 * @author: 魏薏恩
 * @date: 2019/3/4 11:31
 * @description:
 */
@RestController
@RequestMapping("/user")
public class UserActionController extends BaseController {

    @Autowired
    private JWTTools jwtTools;
    @Autowired
    private PassWordUtils passWordUtils;

    @Autowired
    private LaboratoryUserService userService;

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private XyUserDetailServiceImpl xyUserDetailService;


    /**
     * 登录
     *
     * @param loginModel 登录对象
     * @return
     */
    @PostMapping("/login")
    public ResultDTO login(@Valid @RequestBody LoginModel loginModel, BindingResult bindingResult) {
        validParam(bindingResult);
        UserInfoView userInfoView = userService.checkUserInfo(loginModel.getUsername());
        if (userInfoView == null) {
            return ResultDTO.failed(CommonStatusCode.LOGIN_NO_USER);
        } else {
            // 加密用户输入的密码
            if (passWordUtils.matches(loginModel.getPassword(), userInfoView.getPassword())) {
                // 密码验证通过
                if (userInfoView.getAlowable()) {
                    // 验证完成,通过
                    UserInfoModel userInfoModel = setUserInfoModel(userInfoView);
                    // token存redis
                    String md5Token = MD5Utils.encode(userInfoModel.getToken());
                    redisUtils.setValue(RedisPrefix.APP_ONLINE_USER + userInfoModel.getUserId(), md5Token, (long) 24, TimeUnit.HOURS);
                    redisUtils.setValue(RedisPrefix.DETAIL_USER_INFO + userInfoModel.getUserId(), JSON.toJSONString(userInfoModel), (long) 24, TimeUnit.HOURS);
                    return ResultDTO.successed(userInfoModel);
                } else {
                    return ResultDTO.failed(CommonStatusCode.LOGIN_COUNT_NOT_ACTIVE);
                }
            } else {
                // 密码错误
                return ResultDTO.failed(CommonStatusCode.LOGIN_PARAM_ERROR);
            }
        }
    }

    /**
     * 返回用户信息转换
     *
     * @param userInfoView 用户视图信息
     * @return UserInfoModel 用户DTO对象
     */
    private UserInfoModel setUserInfoModel(UserInfoView userInfoView) {
        UserInfoModel userInfoModel = UserConvertToUserInfoModel(userInfoView);
        String jwtToken = jwtTools.generatorToken(userInfoView);
        userInfoModel.setToken(jwtToken);
        return userInfoModel;
    }

    /**
     * 用户entity转viewmodel
     *
     * @param users 用户账号基本信息
     * @return
     */
    private UserInfoModel UserConvertToUserInfoModel(UserInfoView users) {
        UserInfoModel userInfoModel = new UserInfoModel();
        userInfoModel.setTeacherid(users.getTeacherid());
        userInfoModel.setCardno(users.getCardno());
        userInfoModel.setRealname(users.getRealname());
        userInfoModel.setRegisteTime(DateUtil.formatDate(users.getRegistetime()));
        userInfoModel.setUserId(users.getUserid());
        userInfoModel.setUserName(users.getUsername());
        userInfoModel.setIdentityid(users.getIdentityid());
        userInfoModel.setUsertype(users.getUsertype());
        userInfoModel.setUsertypeid(users.getUsertypeid());
        return userInfoModel;
    }
}
