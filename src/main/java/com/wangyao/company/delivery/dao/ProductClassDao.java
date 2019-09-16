package com.wangyao.company.delivery.dao;

import com.wangyao.company.delivery.model.ProductClass;
import com.wangyao.company.delivery.dao.mapper.ProductClassMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wy
 * @date 2019/9/4 0004
 * @description:
 */
@Repository
public class ProductClassDao {

    @Resource
    private ProductClassMapper productClassMapper;

    
    public int deleteByPrimaryKey(Long id) {
        return productClassMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(ProductClass record) {
        return productClassMapper.insert(record);
    }

    
    public int insertSelective(ProductClass record) {
        return productClassMapper.insertSelective(record);
    }

    
    public ProductClass selectByPrimaryKey(Long id) {
        return productClassMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(ProductClass record) {
        return productClassMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(ProductClass record) {
        return productClassMapper.updateByPrimaryKey(record);
    }

    public List<ProductClass> getOrderByCreateTimeDesc() {
        return productClassMapper.getOrderByCreateTimeDesc();
    }

    public int countByName(String name) {
        return productClassMapper.countByName(name);
    }
}
