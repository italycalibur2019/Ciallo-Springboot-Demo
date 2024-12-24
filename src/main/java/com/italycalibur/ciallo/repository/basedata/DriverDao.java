package com.italycalibur.ciallo.repository.basedata;

import com.italycalibur.ciallo.base.BaseJpaDao;
import com.italycalibur.ciallo.domain.basedata.Driver;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverDao extends BaseJpaDao<Driver, Long> {
}
