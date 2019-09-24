package top.coolidea.security.demo.filter.security;

import com.alibaba.fastjson.JSON;
import top.coolidea.security.demo.result.ResultDTO;
import top.coolidea.security.demo.error.CommonStatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: 魏薏恩
 * @date: 2019/3/4 21:25
 * @description:无权访问时统一结果返回
 */
@Slf4j
@Component
public class XyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        log.error("===================LOGINSTATUS:{}", "XyAccessDeniedHandler");
        httpServletResponse.getWriter().write(JSON.toJSONString(ResultDTO.failed(CommonStatusCode.NO_PERMISSION)));
    }
}