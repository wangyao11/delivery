package com.wangyao.company.delivery.action;

import com.wangyao.company.delivery.ResponseEntity;
import com.wangyao.company.delivery.dao.DataDao;
import com.wangyao.company.delivery.dao.DeliveryDayItemDao;
import com.wangyao.company.delivery.form.DeliveryDayTotalForm;
import com.wangyao.company.delivery.vo.DeliveryDayTotalVO;
import com.wangyao.company.delivery.vo.ProductSalesVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wy
 * @date 2019/11/26 0026
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/web/data")
@Api(value = "dataAction", description = "管理员")
public class DataAction {

    @Resource
    private DataDao dataDao;

    @Resource
    private DeliveryDayItemDao deliveryDayItemDao;

    @RequestMapping(value = "getProjectSales", method = RequestMethod.POST)
    @ApiOperation(value = "获取总价", notes = "获取总价")
    public ResponseEntity<List<ProductSalesVO>> getProjectSales() {
        List<ProductSalesVO> productSalesVOS = dataDao.getProductSales();
        return new ResponseEntity<>(productSalesVOS);
    }

    @RequestMapping(value = "listDayTotalByUserIdAndDate", method = RequestMethod.POST)
    @ApiOperation(value = "获取一段时间总计", notes = "获取一段时间总计")
    public ResponseEntity<List<DeliveryDayTotalVO>> listDayTotalByUserIdAndDate(@RequestBody DeliveryDayTotalForm deliveryDayTotalForm) {
        List<DeliveryDayTotalVO> deliveryDayTotalVOS = deliveryDayItemDao.listByUserIdAndDate(deliveryDayTotalForm);
        return new ResponseEntity<>(deliveryDayTotalVOS);
    }
}
