package com.italycalibur.ciallo.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.italycalibur.ciallo.domain.User;
import com.italycalibur.ciallo.dto.RegisterDTO;
import com.italycalibur.ciallo.repository.UserDao;
import com.italycalibur.ciallo.service.UserService;
import com.italycalibur.ciallo.vo.UserInfo;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @description: TODO 
 * @author dhr
 * @date 2024-12-13 下午5:52:24
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public UserInfo login(String username, String password) {
        String decodedPwd = DigestUtil.md5Hex(password);
        User user = userDao.findUserByUsernameAndPassword(username, decodedPwd);
        if (user != null) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUsername(user.getUsername());
            userInfo.setNickname(user.getNickname());
            userInfo.setAvatar(user.getAvatar());
            return userInfo;
        }
        return null;
    }

    @Override
    public User register(RegisterDTO params) {
        User existed = userDao.findUserByUsername(params.getUsername());
        if (existed == null) {
            User user = new User();
            String decodedPwd = DigestUtil.md5Hex(params.getPassword());
            params.setPassword(decodedPwd);
            BeanUtils.copyProperties(params, user);
            return userDao.save(user);
        }
        return null;
    }
}
