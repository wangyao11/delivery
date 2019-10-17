package com.wangyao.company.delivery.action;

import com.wangyao.company.delivery.ResponseEntity;
import com.wangyao.company.delivery.dao.DeliveryItemDao;
import com.wangyao.company.delivery.dao.DeliveryUserProductMapperDao;
import com.wangyao.company.delivery.exception.BusinessException;
import com.wangyao.company.delivery.form.DeliveryUserProductAddForm;
import com.wangyao.company.delivery.form.DeliveryUserProductForm;
import com.wangyao.company.delivery.model.DeliveryItem;
import com.wangyao.company.delivery.model.DeliveryUserProductMapper;
import com.wangyao.company.delivery.model.DeliveryUserProductParam;
import com.wangyao.company.delivery.service.DeliveryUserProductMapperService;
import com.wangyao.company.delivery.util.ValidationUtils;
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
@RequestMapping("/web/deliveryUserProduct")
@Api(value = "deliveryUserProductAction", description = "用户配送单详情")
public class DeliveryUserProductAction {

    @Resource
    private DeliveryUserProductMapperService deliveryUserProductMapperService;
    @Resource
    private DeliveryUserProductMapperDao deliveryUserProductMapperDao;
    @Resource
    private DeliveryItemDao deliveryItemDao;

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
    public ResponseEntity add(@RequestBody DeliveryUserProductAddForm deliveryUserProductAddForm){
        ValidationUtils.validate(deliveryUserProductAddForm);
        if(deliveryUserProductAddForm.getCount() <= 0) {
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
}
