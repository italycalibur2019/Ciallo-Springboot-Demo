package com.italycalibur.ciallo.service;

import com.italycalibur.ciallo.domain.basedata.Driver;
import com.italycalibur.ciallo.dto.DriverSearchDTO;
import com.italycalibur.ciallo.utils.pojo.PageData;
import com.italycalibur.ciallo.utils.pojo.Result;
import com.italycalibur.ciallo.vo.DriverVO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface DriverService {
    PageData<DriverVO> listDriver(DriverSearchDTO params, Pageable pageable, Sort sort);

    Result<Object> addDriver(Driver driver);

    Result<Object> updateDriver(Long id, Driver driver);

    Result<Object> deleteDriver(Long id);
}
