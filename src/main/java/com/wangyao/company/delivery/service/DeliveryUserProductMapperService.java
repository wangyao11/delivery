package com.wangyao.company.delivery.service;

import com.wangyao.company.delivery.dao.DeliveryItemDao;
import com.wangyao.company.delivery.dao.DeliveryUserProductMapperDao;
import com.wangyao.company.delivery.exception.BusinessException;
import com.wangyao.company.delivery.form.DeliveryForm;
import com.wangyao.company.delivery.form.DeliveryUserProductForm;
import com.wangyao.company.delivery.model.DeliveryItem;
import com.wangyao.company.delivery.model.DeliveryUserProductMapper;
import com.wangyao.company.delivery.model.DeliveryUserProductParam;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wy
 * @date 2019/9/4 0004
 * @description:
 */
@Service
public class DeliveryUserProductMapperService{

    @Resource
    private DeliveryUserProductMapperDao deliveryUserProductMapperDao;
    @Resource
    private DeliveryItemDao deliveryItemDao;

    public List<DeliveryUserProductMapper> list(DeliveryUserProductForm deliveryUserProductForm){
        List<Long> deliveryItemIds = new ArrayList<>();
        DeliveryUserProductParam deliveryUserProductParam = new DeliveryUserProductParam();
        if(Objects.nonNull(deliveryUserProductForm.getUserId())) {
            deliveryUserProductParam.setUserId(deliveryUserProductForm.getUserId());
        }
        if(Objects.nonNull(deliveryUserProductForm.getClassType())) {
            deliveryUserProductParam.setClassType(deliveryUserProductForm.getClassType());
        }
        if(Objects.nonNull(deliveryUserProductForm.getStartTime()) && Objects.isNull(deliveryUserProductForm.getEndTime())) {
            List<DeliveryItem> deliveryItems = deliveryItemDao.listByDateTimeOrderByDateTime(DeliveryForm.builder().startTime(deliveryUserProductForm.getStartTime()).endTime(deliveryUserProductForm.getStartTime()).build());
            deliveryItemIds = deliveryItems.stream().map(DeliveryItem::getId).collect(Collectors.toList());
        }
        if(Objects.nonNull(deliveryUserProductForm.getStartTime()) && Objects.nonNull(deliveryUserProductForm.getEndTime())) {
            List<DeliveryItem> deliveryItems = deliveryItemDao.listByDateTimeOrderByDateTime(DeliveryForm.builder().startTime(deliveryUserProductForm.getStartTime()).endTime(deliveryUserProductForm.getEndTime()).build());
            deliveryItemIds = deliveryItems.stream().map(DeliveryItem::getId).collect(Collectors.toList());
        }
        if (CollectionUtils.isEmpty(deliveryItemIds)) {
            throw new BusinessException("配送单不存在");
        }
        deliveryUserProductParam.setDeliveryItemIds(deliveryItemIds);
        List<DeliveryUserProductMapper> deliveryUserProductMappers = deliveryUserProductMapperDao.listByParam(deliveryUserProductParam);
        return getOnlyProductList(deliveryUserProductMappers);
    }

    public List<DeliveryUserProductMapper> listByDeviceItemId(DeliveryUserProductForm deliveryUserProductForm){
        List<Long> deliveryItemIds = new ArrayList<>();
        DeliveryUserProductParam deliveryUserProductParam = new DeliveryUserProductParam();
        deliveryUserProductParam.setUserId(deliveryUserProductForm.getUserId());
        deliveryUserProductParam.setDeliveryItemId(deliveryUserProductForm.getDeliveryItemId());
        List<DeliveryUserProductMapper> deliveryUserProductMappers = deliveryUserProductMapperDao.listByParam(deliveryUserProductParam);
        return getOnlyProductList(deliveryUserProductMappers);
    }

    private List<DeliveryUserProductMapper> getOnlyProductList(List<DeliveryUserProductMapper> deliveryUserProductMappers) {
        List<DeliveryUserProductMapper> deliveryUserProductMapperList = new ArrayList<>();
        Map<Long, DeliveryUserProductMapper> deliveryUserProductMapperMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(deliveryUserProductMappers)) {
            for (DeliveryUserProductMapper deliveryUserProductMapper:deliveryUserProductMappers) {
                DeliveryUserProductMapper userProductMapper;
                userProductMapper = deliveryUserProductMapperMap.get(deliveryUserProductMapper.getProductId());
                if(userProductMapper != null) {
                    userProductMapper.setTotalCount(userProductMapper.getTotalCount() + deliveryUserProductMapper.getTotalCount());
                    deliveryUserProductMapperMap.put(userProductMapper.getProductId(), userProductMapper);
                }else {
                    deliveryUserProductMapperMap.put(deliveryUserProductMapper.getProductId(), deliveryUserProductMapper);
                }
            }
            deliveryUserProductMapperList = new ArrayList<>(deliveryUserProductMapperMap.values());
        }
        return deliveryUserProductMapperList;
    }
}
