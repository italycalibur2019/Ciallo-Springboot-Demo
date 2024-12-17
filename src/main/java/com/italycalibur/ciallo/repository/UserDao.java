package com.italycalibur.ciallo.repository;

import com.italycalibur.ciallo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @description: TODO 
 * @author dhr
 * @date 2024-12-13 下午5:47:32
 * @version 1.0
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findUserByUsername(String username);

    User findUserByUsernameAndPassword(String username, String password);
}
