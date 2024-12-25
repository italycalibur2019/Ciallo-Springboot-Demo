package com.italycalibur.ciallo.controller;

import com.italycalibur.ciallo.domain.basedata.Driver;
import com.italycalibur.ciallo.dto.DriverSearchDTO;
import com.italycalibur.ciallo.service.DriverService;
import com.italycalibur.ciallo.utils.pojo.PageData;
import com.italycalibur.ciallo.utils.pojo.QueryRequest;
import com.italycalibur.ciallo.utils.pojo.Result;
import com.italycalibur.ciallo.vo.DriverVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 车手表管理
 * @author dhr
 * @date 2024-12-24 下午3:27:03
 * @version 1.0
 */
@RestController
@RequestMapping("/driver")
public class DriverController {
    @Resource
    private DriverService driverService;

    @GetMapping("/listDriver")
    public PageData<DriverVO> listDriver(@RequestBody QueryRequest<DriverSearchDTO> queryRequest) {
        return driverService.listDriver(queryRequest.params(), queryRequest.pageable(), queryRequest.sort());
    }

    @PostMapping("/addDriver")
    public Result<Object> addDriver(@RequestBody Driver driver) {
        return driverService.addDriver(driver);
    }

    @PutMapping("/updateDriver/{id}")
    public Result<Object> updateDriver(@PathVariable Long id, @RequestBody Driver driver) {
        return driverService.updateDriver(id, driver);
    }

    @DeleteMapping("/deleteDriver/{id}")
    public Result<Object> deleteDriver(@PathVariable Long id) {
        return driverService.deleteDriver(id);
    }
}
