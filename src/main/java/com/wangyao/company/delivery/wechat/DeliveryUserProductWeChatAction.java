package com.wangyao.company.delivery.wechat;

import com.wangyao.company.delivery.ResponseEntity;
import com.wangyao.company.delivery.dao.DeliveryUserProductMapperDao;
import com.wangyao.company.delivery.form.DeliveryUserProductAddForm;
import com.wangyao.company.delivery.form.DeliveryUserProductForm;
import com.wangyao.company.delivery.form.DeliveryUserProductUpdateCountForm;
import com.wangyao.company.delivery.model.DeliveryUserProductMapper;
import com.wangyao.company.delivery.model.DeliveryUserProductParam;
import com.wangyao.company.delivery.service.DeliveryUserProductMapperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author wy
 * @date 2019/9/11 0011
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/wechat/deliveryUserProduct")
@Api(value = "deliveryUserProductAction", description = "用户配送单详情")
public class DeliveryUserProductWeChatAction {

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

    @RequestMapping(value = "listByDeviceItemId", method = RequestMethod.POST)
    @ApiOperation(value = "查询配送单详情通过配送单Id", notes = "查询配送单详情通过配送单Id")
    public ResponseEntity<List<DeliveryUserProductMapper>> listByDeviceItemId(@RequestBody DeliveryUserProductForm deliveryUserProductForm) {
        List<DeliveryUserProductMapper> deliveryUserProductMappers = deliveryUserProductMapperService.listByDeviceItemId(deliveryUserProductForm);
        ResponseEntity<List<DeliveryUserProductMapper>> listResponseEntity = new ResponseEntity<>();
        listResponseEntity.setValue(deliveryUserProductMappers);
        return listResponseEntity;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ApiOperation(value = "add", notes = "添加或删除商品进入配送单")
    public ResponseEntity add(@RequestBody DeliveryUserProductAddForm deliveryUserProductAddForm) {

        DeliveryUserProductMapper deliveryUserProductMapper = deliveryUserProductMapperDao.getByUserIdAndProductIdAndDeliveryItemId(DeliveryUserProductParam.builder()
                .userId(deliveryUserProductAddForm.getUserId())
                .productId(deliveryUserProductAddForm.getProductId())
                .deliveryItemId(deliveryUserProductAddForm.getDeliveryItemId()).build());

        if (Objects.isNull(deliveryUserProductMapper) && deliveryUserProductAddForm.getCount() > 0) {
            deliveryUserProductMapperDao.insert(DeliveryUserProductMapper.builder()
                    .userId(deliveryUserProductAddForm.getUserId())
                    .productId(deliveryUserProductAddForm.getProductId())
                    .deliveryItemId(deliveryUserProductAddForm.getDeliveryItemId())
                    .totalCount(deliveryUserProductAddForm.getCount()).build());
        } else if (Objects.nonNull(deliveryUserProductMapper) && deliveryUserProductAddForm.getCount() == 0) {
            deliveryUserProductMapperDao.deleteByPrimaryKey(deliveryUserProductMapper.getId());
        } else {
            deliveryUserProductMapper.setTotalCount(deliveryUserProductAddForm.getCount());
            deliveryUserProductMapperDao.updateByPrimaryKeySelective(deliveryUserProductMapper);
        }
        return new ResponseEntity();
    }

    @RequestMapping(value = "updateCountById", method = RequestMethod.POST)
    @ApiOperation(value = "updateCountById", notes = "修改商品数量")
    public ResponseEntity updateCountById(@RequestBody DeliveryUserProductUpdateCountForm deliveryUserProductUpdateCountForm) {
        deliveryUserProductMapperDao.updateByPrimaryKeySelective(DeliveryUserProductMapper.builder()
                .id(deliveryUserProductUpdateCountForm.getId())
                .totalCount(deliveryUserProductUpdateCountForm.getCount()).build());
        return new ResponseEntity();
    }


    @RequestMapping(value = "deleteById", method = RequestMethod.POST)
    @ApiOperation(value = "deleteById", notes = "删除商品从配送单中")
    public ResponseEntity deleteById(@RequestParam("id") Long id) {
        deliveryUserProductMapperDao.deleteByPrimaryKey(id);
        return new ResponseEntity();
    }
}
