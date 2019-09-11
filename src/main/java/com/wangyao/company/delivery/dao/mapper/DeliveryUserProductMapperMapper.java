package com.wangyao.company.delivery.dao.mapper;
import com.wangyao.company.delivery.form.DeliveryUserProductForm;
import com.wangyao.company.delivery.model.DeliveryUserProductParam;
import org.apache.ibatis.annotations.Param;
import java.util.Date;

import com.wangyao.company.delivery.model.DeliveryUserProductMapper;

import java.util.List;

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

    List<DeliveryUserProductMapper> listByParam(DeliveryUserProductParam deliveryUserProductParam);


}