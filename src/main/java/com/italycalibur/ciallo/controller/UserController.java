package com.italycalibur.ciallo.controller;

import com.italycalibur.ciallo.domain.User;
import com.italycalibur.ciallo.dto.LoginDTO;
import com.italycalibur.ciallo.dto.RegisterDTO;
import com.italycalibur.ciallo.service.UserService;
import com.italycalibur.ciallo.utils.Result;
import com.italycalibur.ciallo.vo.UserInfoVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: TODO 
 * @author dhr
 * @date 2024-12-13 下午5:57:30
 * @version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result<UserInfoVO> login(@RequestBody LoginDTO params) {
        UserInfoVO userInfoVO = userService.login(params.getUsername(), params.getPassword());
        if (userInfoVO != null) {
            return Result.ok("登录成功！", userInfoVO);
        }else {
            return Result.fail("500", "用户名或密码错误！");
        }
    }

    @PostMapping("/register")
    public Result<Object> register(@RequestBody RegisterDTO params) {
        User register = userService.register(params);
        if (register != null) {
            return Result.ok("注册成功！");
        }else {
            return Result.fail("500", "注册失败！");
        }
    }
}
