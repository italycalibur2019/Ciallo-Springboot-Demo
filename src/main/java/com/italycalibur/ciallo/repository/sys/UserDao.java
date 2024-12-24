package com.italycalibur.ciallo.repository.sys;

import com.italycalibur.ciallo.base.BaseJpaDao;
import com.italycalibur.ciallo.domain.sys.User;
import org.springframework.stereotype.Repository;

/**
 * @description: TODO 
 * @author dhr
 * @date 2024-12-13 下午5:47:32
 * @version 1.0
 */
@Repository
public interface UserDao extends BaseJpaDao<User, Long> {
    User findUserByUsername(String username);

    User findUserByUsernameAndPassword(String username, String password);
}
