package com.italycalibur.ciallo.service.impl;

import com.italycalibur.ciallo.domain.sys.User;
import com.italycalibur.ciallo.repository.sys.UserDao;
import com.italycalibur.ciallo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: TODO 
 * @author dhr
 * @date 2024-12-19 上午10:02:07
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public List<User> list() {
        return userDao.findAll();
    }
}
