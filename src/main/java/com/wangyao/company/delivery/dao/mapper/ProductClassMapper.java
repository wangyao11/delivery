package com.wangyao.company.delivery.dao.mapper;

import com.wangyao.company.delivery.model.ProductClass;

/**
 * @author wy
 * @date 2019/9/4 0004
 * @description:
 */
public interface ProductClassMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductClass record);

    int insertSelective(ProductClass record);

    ProductClass selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductClass record);

    int updateByPrimaryKey(ProductClass record);
}