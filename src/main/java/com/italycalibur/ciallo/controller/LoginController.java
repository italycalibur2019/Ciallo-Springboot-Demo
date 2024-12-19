package com.italycalibur.ciallo.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.italycalibur.ciallo.domain.User;
import com.italycalibur.ciallo.dto.LoginDTO;
import com.italycalibur.ciallo.dto.RefreshDTO;
import com.italycalibur.ciallo.dto.RegisterDTO;
import com.italycalibur.ciallo.service.LoginService;
import com.italycalibur.ciallo.utils.Result;
import com.italycalibur.ciallo.vo.RefreshVO;
import com.italycalibur.ciallo.vo.RouterVO;
import com.italycalibur.ciallo.vo.UserInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @description: 登录注册管理
 * @author dhr
 * @date 2024-12-13 下午5:57:30
 * @version 1.0
 */
@RestController
public class LoginController {
    @Resource
    private LoginService loginService;

    /**
     * 登录
     * @param params 登录参数
     * @return Result<UserInfo> 用户信息
     */
    @PostMapping("/login")
    public Result<UserInfo> login(@RequestBody LoginDTO params) {
        UserInfo userInfo = loginService.login(params.getUsername(), params.getPassword());
        if (userInfo != null) {
            return Result.ok("登录成功！", userInfo);
        }else {
            return Result.fail("500", "用户名或密码错误！");
        }
    }

    /**
     * 注册
     * @param params 注册参数
     * @return Result<String>
     */
    @PostMapping("/register")
    public Result<String> register(@RequestBody RegisterDTO params) {
        User register = loginService.register(params);
        if (register != null) {
            return Result.ok("注册成功！");
        }else {
            return Result.fail("500", "注册失败！");
        }
    }

    /**
     * 刷新令牌
     * @param params 刷新参数
     * @return Result<RefreshVO>
     */
    @PostMapping("/refresh-token")
    public Result<RefreshVO> refreshToken(@RequestBody RefreshDTO params) {
        RefreshVO vo = loginService.refreshToken(params);
        if (vo != null) {
            return Result.ok("刷新成功！", vo);
        }else {
            return Result.fail("500", "刷新失败！");
        }
    }

    /**
     * 模拟获取动态路由
     * @return Result<Object>
     */
    @GetMapping("/get-async-routes")
    public Result<Object> getAsyncRoutes() {
        List<RouterVO> list = loginService.getAsyncRoutes();
        if (list != null) {
            String jsonStr = JSON.toJSONString(list);
            List<Map<String, Object>> maps = JSON.parseObject(jsonStr, new TypeReference<>() {});
            return Result.ok("获取路由成功！", maps);
        }else {
            return Result.fail("500", "获取路由失败！");
        }
    }

    /**
     * 登出
     * @return Result<String>
     */
    @PostMapping("/logout")
    public Result<String> logout() {
        StpUtil.logout();
        return Result.ok("退出成功！");
    }
}
