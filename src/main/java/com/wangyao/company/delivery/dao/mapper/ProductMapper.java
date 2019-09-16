package com.wangyao.company.delivery.dao.mapper;
import com.wangyao.company.delivery.form.ProductForm;
import org.apache.ibatis.annotations.Param;
import java.util.List;

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

    List<Product> listByForm(ProductForm productForm);

    int countByName(@Param("name")String name);

}