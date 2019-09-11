package com.wangyao.company.delivery.dao;

import com.wangyao.company.delivery.form.DeliveryUserProductForm;
import com.wangyao.company.delivery.model.DeliveryUserProductMapper;
import com.wangyao.company.delivery.dao.mapper.DeliveryUserProductMapperMapper;
import com.wangyao.company.delivery.model.DeliveryUserProductParam;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wy
 * @date 2019/9/4 0004
 * @description:
 */
@Repository
public class DeliveryUserProductMapperDao {

    @Resource
    private DeliveryUserProductMapperMapper deliveryUserProductMapperMapper;

    
    public int deleteByPrimaryKey(Long id) {
        return deliveryUserProductMapperMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(DeliveryUserProductMapper record) {
        return deliveryUserProductMapperMapper.insert(record);
    }

    
    public int insertSelective(DeliveryUserProductMapper record) {
        return deliveryUserProductMapperMapper.insertSelective(record);
    }

    
    public DeliveryUserProductMapper selectByPrimaryKey(Long id) {
        return deliveryUserProductMapperMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(DeliveryUserProductMapper record) {
        return deliveryUserProductMapperMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(DeliveryUserProductMapper record) {
        return deliveryUserProductMapperMapper.updateByPrimaryKey(record);
    }

    public List<DeliveryUserProductMapper> listByParam(DeliveryUserProductParam deliveryUserProductParam) {
        return deliveryUserProductMapperMapper.listByParam(deliveryUserProductParam);
    }

}
