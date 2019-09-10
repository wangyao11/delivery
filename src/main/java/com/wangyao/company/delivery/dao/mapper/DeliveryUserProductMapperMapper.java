package com.wangyao.company.delivery.dao.mapper;

import com.wangyao.company.delivery.model.DeliveryUserProductMapper;

/**
 * @author wy
 * @date 2019/9/4 0004
 * @description:
 */
public interface DeliveryUserProductMapperMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DeliveryUserProductMapper record);

    int insertSelective(DeliveryUserProductMapper record);

    DeliveryUserProductMapper selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DeliveryUserProductMapper record);

    int updateByPrimaryKey(DeliveryUserProductMapper record);
}