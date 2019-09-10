package com.wangyao.company.delivery.dao.mapper;

import com.wangyao.company.delivery.model.Product;

/**
 * @author wy
 * @date 2019/9/4 0004
 * @description:
 */
public interface ProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}