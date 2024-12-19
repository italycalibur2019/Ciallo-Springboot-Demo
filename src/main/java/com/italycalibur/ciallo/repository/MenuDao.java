package com.italycalibur.ciallo.repository;

import com.italycalibur.ciallo.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dhr
 * @version 1.0
 * @description: TODO
 * @date 2024-12-19 下午3:22:10
 */
@Repository
public interface MenuDao extends JpaRepository<Menu, Long> {
    @Query("select tm from Menu tm left join Permission tp on tp.menuId = tm.id where tm.parentId = 0 and tp.roleId = ?1")
    List<Menu> findTopMenusByRole(Long roleId);
    @Query("select tm from Menu tm where tm.parentId = ?1")
    List<Menu> findChildren(Long parentId);

}
