package com.wangyao.company.delivery.dao;

import com.wangyao.company.delivery.model.Product;
import com.wangyao.company.delivery.dao.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author wy
 * @date 2019/9/4 0004
 * @description:
 */
@Repository
public class ProductDao {

    @Resource
    private ProductMapper productMapper;

    
    public int deleteByPrimaryKey(Long id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Product record) {
        return productMapper.insert(record);
    }

    
    public int insertSelective(Product record) {
        return productMapper.insertSelective(record);
    }

    
    public Product selectByPrimaryKey(Long id) {
        return productMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(Product record) {
        return productMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Product record) {
        return productMapper.updateByPrimaryKey(record);
    }

}
