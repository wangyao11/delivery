package com.wangyao.company.delivery.service;

import com.wangyao.company.delivery.dao.DeliveryItemDao;
import com.wangyao.company.delivery.dao.DeliveryUserProductMapperDao;
import com.wangyao.company.delivery.form.DeliveryForm;
import com.wangyao.company.delivery.model.DeliveryItem;
import com.wangyao.company.delivery.model.DeliveryUserProductMapper;
import com.wangyao.company.delivery.model.DeliveryUserProductParam;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author wy
 * @date 2019/9/4 0004
 * @description:
 */
@Service
public class DeliveryItemService{

    @Resource
    private DeliveryItemDao deliveryItemDao;
    @Resource
    private DeliveryUserProductMapperDao deliveryUserProductMapperDao;

    public List<DeliveryItem> list(HttpServletRequest request, DeliveryForm deliveryForm){
        Long userId = (Long)request.getAttribute("userId");
        List<DeliveryItem> deliveryItems = deliveryItemDao.listByDateTimeOrderByDateTime(deliveryForm);
        if(!CollectionUtils.isEmpty(deliveryItems)) {
            for (DeliveryItem deliveryItem:deliveryItems) {
                List<DeliveryUserProductMapper> deliveryUserProductMappers = deliveryUserProductMapperDao.listByParam(DeliveryUserProductParam.builder()
                    .deliveryItemId(deliveryItem.getId())
                    .userId(userId).build());
                deliveryItem.setProductCount(deliveryUserProductMappers.size());
            }
        }
        return deliveryItems;
    }

    public List<DeliveryItem> oldList(HttpServletRequest request, DeliveryForm deliveryForm){
        Long userId = (Long)request.getAttribute("userId");
        List<DeliveryItem> deliveryItems = deliveryItemDao.listByDateTimeOrderByDateTimeDesc(deliveryForm);
        if(!CollectionUtils.isEmpty(deliveryItems)) {
            for (DeliveryItem deliveryItem:deliveryItems) {
                List<DeliveryUserProductMapper> deliveryUserProductMappers = deliveryUserProductMapperDao.listByParam(DeliveryUserProductParam.builder()
                        .deliveryItemId(deliveryItem.getId())
                        .userId(userId).build());
                deliveryItem.setProductCount(deliveryUserProductMappers.size());
            }
        }
        return deliveryItems;
    }
}
