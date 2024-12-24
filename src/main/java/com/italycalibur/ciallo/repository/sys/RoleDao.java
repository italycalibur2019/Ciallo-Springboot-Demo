package com.italycalibur.ciallo.repository.sys;

import com.italycalibur.ciallo.base.BaseJpaDao;
import com.italycalibur.ciallo.domain.sys.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dhr
 * @version 1.0
 * @description: TODO
 * @date 2024-12-19 下午3:11:08
 */
@Repository
public interface RoleDao extends BaseJpaDao<Role, Long> {
    @Query("select tr from Role tr left join UserRole tur on tur.roleId = tr.id where tur.userId = ?1")
    List<Role> findRolesByUserId(Long userId);
}
