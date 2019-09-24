package top.coolidea.security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.coolidea.security.demo.entity.LaboratoryUser;
import top.coolidea.security.demo.result.ResultDTO;
import top.coolidea.security.demo.service.LaboratoryUserService;

/**
 * @auther: 魏薏恩
 * @date: 2019/9/24 13:42
 * @description:
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private LaboratoryUserService laboratoryUserService;

    @GetMapping("/")
    @PreAuthorize("hasAuthority('1')")
    public ResultDTO index() {
        return ResultDTO.successed("USER");
    }

    @GetMapping("/myinfo/{id}")
    public ResultDTO myInfo(@PathVariable int id) {
        return ResultDTO.successed(laboratoryUserService.selectByPrimaryKey(id));
    }
}
