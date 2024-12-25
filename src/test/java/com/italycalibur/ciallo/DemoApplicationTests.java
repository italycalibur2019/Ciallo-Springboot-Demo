package com.italycalibur.ciallo;

import cn.hutool.crypto.digest.DigestUtil;
import com.italycalibur.ciallo.domain.basedata.Driver;
import com.italycalibur.ciallo.domain.sys.User;
import com.italycalibur.ciallo.repository.basedata.DriverDao;
import com.italycalibur.ciallo.repository.sys.UserDao;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(DigestUtil.md5Hex("abc1234."));
    }

    @Resource
    private UserDao userDao;
    @Resource
    private DriverDao driverDao;

    @Test
    void testMultipleDb() {
        List<User> userAll = userDao.findAll();
        userAll.forEach(System.out::println);
        List<Driver> driverAll = driverDao.findAll();
        driverAll.forEach(System.out::println);
    }

}
