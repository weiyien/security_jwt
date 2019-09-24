package top.coolidea.security.demo.filter.security;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import top.coolidea.security.demo.error.CommonStatusCode;
import top.coolidea.security.demo.result.ResultDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: 魏薏恩
 * @date: 2019/3/4 21:22
 * @description:用户未登录时统一结果返回
 */
@Slf4j
@Component
public class XyAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        log.error("===================LOGINSTATUS:{}", "XyAuthenticationEntryPoint");
        httpServletResponse.getWriter().write(JSON.toJSONString(ResultDTO.failed(CommonStatusCode.NO_PERMISSION)));
    }
}