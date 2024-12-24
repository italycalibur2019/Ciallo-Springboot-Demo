package com.italycalibur.ciallo.repository.sys;

import com.italycalibur.ciallo.base.BaseJpaDao;
import com.italycalibur.ciallo.domain.sys.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseJpaDao<User, Long> {
    User findUserByUsername(String username);

    User findUserByUsernameAndPassword(String username, String password);
}
