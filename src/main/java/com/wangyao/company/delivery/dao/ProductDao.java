package com.wangyao.company.delivery.dao;

import com.wangyao.company.delivery.form.ProductForm;
import com.wangyao.company.delivery.model.Product;
import com.wangyao.company.delivery.dao.mapper.ProductMapper;
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

    
    public int updateById(Product record) {
        return productMapper.updateById(record);
    }

    public List<Product> listByForm(ProductForm productForm){
        return productMapper.listByForm(productForm);
    }

    public int countByName(String name) {
        return productMapper.countByName(name);
    }

}
