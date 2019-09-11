package com.wangyao.company.delivery.wechat;

import com.wangyao.company.delivery.ResponseEntity;
import com.wangyao.company.delivery.form.DeliveryForm;
import com.wangyao.company.delivery.model.DeliveryItem;
import com.wangyao.company.delivery.service.DeliveryItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wy
 * @date 2019/9/7 0007
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/wechat/deliveryItem")
@Api(value = "deliveryItemAction", description = "配送单")
public class DeliveryItemAction {

    @Resource
    private DeliveryItemService deliveryItemService;

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ApiOperation(value = "查询配送单", notes = "查询配送单")
    ResponseEntity<List<DeliveryItem>> list(
            @ApiParam(value = "查询所有用户", name = "pageParam") @RequestBody DeliveryForm deliveryForm
    ) {
        List<DeliveryItem> deliveryItems = deliveryItemService.list(deliveryForm);
        ResponseEntity<List<DeliveryItem>> deliveryItemResponseEntity = new ResponseEntity<>();
        deliveryItemResponseEntity.setValue(deliveryItems);
        return deliveryItemResponseEntity;
    }
}
