package com.italycalibur.ciallo.service;

import com.italycalibur.ciallo.domain.basedata.Driver;
import com.italycalibur.ciallo.dto.DriverSearchDTO;
import com.italycalibur.ciallo.utils.PageData;
import com.italycalibur.ciallo.utils.Result;
import com.italycalibur.ciallo.vo.DriverVO;
import org.springframework.data.domain.Pageable;

/**
 * @author dhr
 * @version 1.0
 * @description: TODO
 * @date 2024-12-24 下午3:27:33
 */
public interface DriverService {
    PageData<DriverVO> listDriver(DriverSearchDTO params, Pageable pageable);

    Result<Object> addDriver(Driver driver);

    Result<Object> updateDriver(Long id, Driver driver);

    Result<Object> deleteDriver(Long id);
}
