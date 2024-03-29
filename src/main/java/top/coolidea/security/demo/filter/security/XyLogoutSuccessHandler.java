package top.coolidea.security.demo.filter.security;

import com.alibaba.fastjson.JSON;
import top.coolidea.security.demo.result.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: 魏薏恩
 * @date: 2019/3/4 21:28
 * @description:退出成功时统一结果返回
 */
@Slf4j
@Component
public class XyLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        log.error("===================LOGINSTATUS:{}", "XyLogoutSuccessHandler");
        httpServletResponse.getWriter().write(JSON.toJSONString(ResultDTO.successed("退出登录成功")));
    }

}
