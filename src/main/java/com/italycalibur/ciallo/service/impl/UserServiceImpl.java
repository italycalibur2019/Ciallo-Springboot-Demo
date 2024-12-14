package com.italycalibur.ciallo.service.impl;

import com.italycalibur.ciallo.domain.User;
import com.italycalibur.ciallo.dto.RegisterDTO;
import com.italycalibur.ciallo.repository.UserDao;
import com.italycalibur.ciallo.service.UserService;
import com.italycalibur.ciallo.vo.UserInfoVO;
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
    public UserInfoVO login(String username, String password) {
        User user = userDao.findUserByUsernameAndPassword(username, password);
        if (user != null) {
            UserInfoVO userInfoVO = new UserInfoVO();
            userInfoVO.setUsername(user.getUsername());
            userInfoVO.setNickname(user.getNickname());
            userInfoVO.setAvatar(user.getAvatar());
            return userInfoVO;
        }
        return null;
    }

    @Override
    public User register(RegisterDTO params) {
        User existed = userDao.findUserByUsername(params.getUsername());
        if (existed == null) {
            User user = new User();
            BeanUtils.copyProperties(params, user);
            return userDao.save(user);
        }
        return null;
    }
}
