package com.italycalibur.ciallo.service.impl;

import com.italycalibur.ciallo.domain.sys.User;
import com.italycalibur.ciallo.repository.sys.UserDao;
import com.italycalibur.ciallo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public List<User> list() {
        return userDao.findAll();
    }
}
