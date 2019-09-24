package top.coolidea.security.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.coolidea.security.demo.result.ResultDTO;

/**
 * @auther: 魏薏恩
 * @date: 2019/9/24 13:38
 * @description:
 */
@RequestMapping("admin")
@RestController
@PreAuthorize("hasAnyAuthority('2','3')")
public class AdminController {
    @GetMapping("/")
    public ResultDTO index() {
        return ResultDTO.successed("admin");
    }
}
