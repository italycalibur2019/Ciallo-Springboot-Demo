package com.italycalibur.ciallo.service.impl;

import com.italycalibur.ciallo.domain.basedata.Driver;
import com.italycalibur.ciallo.dto.DriverSearchDTO;
import com.italycalibur.ciallo.repository.basedata.DriverDao;
import com.italycalibur.ciallo.service.DriverService;
import com.italycalibur.ciallo.utils.PageData;
import com.italycalibur.ciallo.utils.Result;
import com.italycalibur.ciallo.vo.DriverVO;
import jakarta.annotation.Resource;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {
    @Resource
    private DriverDao driverDao;

    @Override
    public PageData<DriverVO> listDriver(DriverSearchDTO params, Pageable pageable) {
        Page<Driver> page = driverDao.findAll((Specification<Driver>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (params != null) {
                if (params.getFirstName() != null) {
                    predicates.add(criteriaBuilder.like(root.get("firstName"), "%" + params.getFirstName() + "%"));
                }
                if (params.getLastName() != null) {
                    predicates.add(criteriaBuilder.like(root.get("lastName"), "%" + params.getLastName() + "%"));
                }
                if (params.getCode() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("code"), params.getCode()));
                }
                if (params.getCountry() != null) {
                    predicates.add(criteriaBuilder.like(root.get("country"), "%" + params.getCountry() + "%"));
                }
            }
            return query.where(predicates.toArray(new Predicate[0])).getRestriction();
        }, pageable);
        List<Driver> content = page.getContent();
        List<DriverVO> rows = new ArrayList<>();
        for (Driver driver : content) {
            DriverVO row = new DriverVO();
            BeanUtils.copyProperties(driver, row);
            if ("China".equalsIgnoreCase(driver.getCountry())) {
                row.setFullName(driver.getLastName() + " " + driver.getFirstName());
            }else {
                row.setFullName(driver.getFirstName() + " " + driver.getLastName());
            }
            rows.add(row);
        }
        return PageData.of(page.getNumber(), page.getTotalElements(), rows, page.getTotalPages());
    }

    @Override
    public Result<Object> addDriver(Driver driver) {
        driverDao.save(driver);
        return Result.ok("添加成功！", null);
    }

    @Override
    public Result<Object> updateDriver(Long id, Driver driver) {
        Driver existingDriver = driverDao.findById(id).orElse(null);
        if (existingDriver != null) {
            BeanUtils.copyProperties(driver, existingDriver);
            driverDao.save(existingDriver);
            return Result.ok("更新成功！", null);
        }else {
            return Result.fail("500", "更新失败！");
        }
    }

    @Override
    public Result<Object> deleteDriver(Long id) {
        driverDao.deleteById(id);
        return Result.ok("删除成功！", null);
    }
}
