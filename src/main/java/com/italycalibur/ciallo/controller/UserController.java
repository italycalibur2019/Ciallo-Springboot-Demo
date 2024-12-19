package com.italycalibur.ciallo.controller;

import com.italycalibur.ciallo.domain.User;
import com.italycalibur.ciallo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: TODO 
 * @author dhr
 * @date 2024-12-19 上午10:01:06
 * @version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
    }
}
