package com.wangyao.company.delivery.action;

import com.wangyao.company.delivery.ResponseEntity;
import com.wangyao.company.delivery.dao.DeliveryDayItemDao;
import com.wangyao.company.delivery.dao.DeliveryItemDao;
import com.wangyao.company.delivery.dao.DeliveryUserProductMapperDao;
import com.wangyao.company.delivery.dao.ProductDao;
import com.wangyao.company.delivery.exception.BusinessException;
import com.wangyao.company.delivery.form.DeliverySaveItemForm;
import com.wangyao.company.delivery.form.DeliveryUserProductAddForm;
import com.wangyao.company.delivery.form.DeliveryUserProductForm;
import com.wangyao.company.delivery.form.DeliveryUserProductSaveForm;
import com.wangyao.company.delivery.model.*;
import com.wangyao.company.delivery.service.DeliveryUserProductMapperService;
import com.wangyao.company.delivery.util.ValidationUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    @Resource
    private DeliveryItemDao deliveryItemDao;
    @Resource
    private DeliveryDayItemDao deliveryDayItemDao;
    @Resource
    private ProductDao productDao;

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

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ApiOperation(value = "add", notes = "添加商品进入配送单")
    public ResponseEntity add(@RequestBody DeliveryUserProductAddForm deliveryUserProductAddForm) {
        ValidationUtils.validate(deliveryUserProductAddForm);
        if (deliveryUserProductAddForm.getCount() <= 0) {
            throw new BusinessException("请输入产品数量!");
        }
        DeliveryItem deliveryItem = deliveryItemDao.getByDateTime(deliveryUserProductAddForm.getDateTime());
        if (Objects.isNull(deliveryItem)) {
            throw new BusinessException("产品配送单不存在!");
        }
        DeliveryUserProductMapper deliveryUserProductMapper = deliveryUserProductMapperDao.getByUserIdAndProductIdAndDeliveryItemId(DeliveryUserProductParam.builder()
                .userId(deliveryUserProductAddForm.getUserId())
                .productId(deliveryUserProductAddForm.getProductId())
                .deliveryItemId(deliveryItem.getId()).build());

        if (Objects.isNull(deliveryUserProductMapper)) {
            deliveryUserProductMapperDao.insert(DeliveryUserProductMapper.builder()
                    .userId(deliveryUserProductAddForm.getUserId())
                    .productId(deliveryUserProductAddForm.getProductId())
                    .deliveryItemId(deliveryItem.getId())
                    .totalCount(deliveryUserProductAddForm.getCount()).build());
        } else {
            deliveryUserProductMapper.setTotalCount(deliveryUserProductAddForm.getCount());
            deliveryUserProductMapperDao.updateByPrimaryKeySelective(deliveryUserProductMapper);
        }
        return new ResponseEntity();
    }

    @RequestMapping(value = "saveDelivery", method = RequestMethod.POST)
    @ApiOperation(value = "saveDelivery", notes = "保存配送单")
    public ResponseEntity saveDelivery(@RequestBody DeliveryUserProductSaveForm deliveryUserProductSaveForm) {
        List<DeliveryDayItem> deliveryDayItems = new ArrayList<>();
        ValidationUtils.validate(deliveryUserProductSaveForm);
        Long userId = deliveryUserProductSaveForm.getUserId();
        DeliveryItem deliveryItem = deliveryItemDao.getByDateTime(deliveryUserProductSaveForm.getDateTime());
        if (Objects.isNull(deliveryItem)) {
            throw new BusinessException("产品配送单不存在!");
        }
        Long deliveryItemId = deliveryItem.getId();

//        if (CollectionUtils.isEmpty(deliveryUserProductSaveForm.getValues())) {
//            throw new BusinessException("保存失败，商品列表不能为空");
//        }


        List<DeliverySaveItemForm> deliverySaveItemForms = deliveryUserProductSaveForm.getValues();
        if (StringUtils.isEmpty(deliveryUserProductSaveForm.getClassType())) {
            deliveryDayItemDao.deleteBydeliveryItemId(deliveryItemId, deliveryUserProductSaveForm.getUserId(), 0);
            deliveryDayItemDao.deleteBydeliveryItemId(deliveryItemId, deliveryUserProductSaveForm.getUserId(), 1);
        } else if ("0".equals(deliveryUserProductSaveForm.getClassType())) {
            deliveryDayItemDao.deleteBydeliveryItemId(deliveryItemId, deliveryUserProductSaveForm.getUserId(), 0);
        } else if ("1".equals(deliveryUserProductSaveForm.getClassType())) {
            deliveryDayItemDao.deleteBydeliveryItemId(deliveryItemId, deliveryUserProductSaveForm.getUserId(), 1);
        }

        for (DeliverySaveItemForm deliverySaveItemForm : deliverySaveItemForms) {
            Long productId = deliverySaveItemForm.getProductId();
            DeliveryDayItem deliveryDayItemMap = deliveryDayItemDao.getByUserIdAndProductIdAndDeliveryItemId(userId, productId, deliveryItemId);
            if (deliveryDayItemMap != null) {
                deliveryDayItemDao.deleteById(deliveryDayItemMap.getId());
            }
            DeliveryDayItem deliveryDayItem = DeliveryDayItem.builder()
                    .deliveryItemId(deliveryItemId)
                    .productId(productId)
                    .userId(userId)
                    .totalCount(deliverySaveItemForm.getTotalCount())
                    .totalPrice(multiply(deliverySaveItemForm.getTotalPrice()))
                    .build();
            deliveryDayItems.add(deliveryDayItem);
        }
        if (!CollectionUtils.isEmpty(deliveryDayItems)) {
            deliveryDayItemDao.insertList(deliveryDayItems);
        }
        return new ResponseEntity();
    }

    @RequestMapping(value = "isSaveDelivery", method = RequestMethod.POST)
    @ApiOperation(value = "isSaveDelivery", notes = "是否保存配送单，true 保存 false 未保存")
    public ResponseEntity<Boolean> isSaveDelivery(@RequestBody DeliveryUserProductSaveForm deliveryUserProductSaveForm) {
        ValidationUtils.validate(deliveryUserProductSaveForm);
        Long userId = deliveryUserProductSaveForm.getUserId();
        DeliveryItem deliveryItem = deliveryItemDao.getByDateTime(deliveryUserProductSaveForm.getDateTime());
        if (Objects.isNull(deliveryItem)) {
            throw new BusinessException("产品配送单不存在!");
        }
        Long deliveryItemId = deliveryItem.getId();
        List<DeliveryDayItem> deliveryDayItems = deliveryDayItemDao.getByUserIdAndDeliveryItemId(userId, deliveryItemId);
        Boolean isSave = true;
        if (CollectionUtils.isEmpty(deliveryDayItems)) {
            isSave = false;
        }
        return new ResponseEntity<>(isSave);
    }

    public static int multiply(Double value1) {
        BigDecimal b1 = new BigDecimal(String.valueOf(value1));
        BigDecimal b2 = new BigDecimal(100);
        return b1.multiply(b2).intValue();
    }
}
