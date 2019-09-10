package com.wangyao.company.delivery.dao.mapper;

import com.wangyao.company.delivery.model.DeliveryItem;

/**
 * @author wy
 * @date 2019/9/4 0004
 * @description:
 */
public interface DeliveryItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DeliveryItem record);

    int insertSelective(DeliveryItem record);

    DeliveryItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DeliveryItem record);

    int updateByPrimaryKey(DeliveryItem record);
}