package com.italycalibur.ciallo;

import cn.hutool.crypto.digest.DigestUtil;
import com.italycalibur.ciallo.domain.sys.User;
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

    @Test
    void testSysDb() {
        List<User> all = userDao.findAll();
        all.forEach(System.out::println);
    }

}
