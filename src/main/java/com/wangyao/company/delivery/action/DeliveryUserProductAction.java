package com.wangyao.company.delivery.action;

import com.wangyao.company.delivery.ResponseEntity;
import com.wangyao.company.delivery.dao.DeliveryUserProductMapperDao;
import com.wangyao.company.delivery.form.DeliveryUserProductForm;
import com.wangyao.company.delivery.model.DeliveryUserProductMapper;
import com.wangyao.company.delivery.service.DeliveryUserProductMapperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wy
 * @date 2019/9/11 0011
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/web/deliveryUserProduct")
@Api(value = "deliveryUserProductAction", description = "用户配送单详情")
public class DeliveryUserProductAction {

    @Resource
    private DeliveryUserProductMapperService deliveryUserProductMapperService;
    @Resource
    private DeliveryUserProductMapperDao deliveryUserProductMapperDao;

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ApiOperation(value = "查询配送单详情", notes = "查询用户某一天的配送单详情")
    public ResponseEntity<List<DeliveryUserProductMapper>> list(@RequestBody DeliveryUserProductForm deliveryUserProductForm) {
        List<DeliveryUserProductMapper> deliveryUserProductMappers = deliveryUserProductMapperService.list(deliveryUserProductForm);
        ResponseEntity<List<DeliveryUserProductMapper>> listResponseEntity = new ResponseEntity<>();
        listResponseEntity.setValue(deliveryUserProductMappers);
        return listResponseEntity;
    }

    @RequestMapping(value = "deleteById", method = RequestMethod.POST)
    @ApiOperation(value = "deleteById", notes = "删除商品从配送单中")
    public ResponseEntity deleteById(@RequestParam("id") Long id) {
        deliveryUserProductMapperDao.deleteByPrimaryKey(id);
        return new ResponseEntity();
    }

}
