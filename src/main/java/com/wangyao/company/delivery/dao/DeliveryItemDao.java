package com.wangyao.company.delivery.dao;

import com.wangyao.company.delivery.form.DeliveryForm;
import com.wangyao.company.delivery.model.DeliveryItem;
import com.wangyao.company.delivery.dao.mapper.DeliveryItemMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wy
 * @date 2019/9/4 0004
 * @description:
 */
@Repository
public class DeliveryItemDao {

    @Resource
    private DeliveryItemMapper deliveryItemMapper;

    
    public int deleteByPrimaryKey(Long id) {
        return deliveryItemMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(DeliveryItem record) {
        return deliveryItemMapper.insert(record);
    }

    
    public int insertSelective(DeliveryItem record) {
        return deliveryItemMapper.insertSelective(record);
    }

    
    public DeliveryItem selectByPrimaryKey(Long id) {
        return deliveryItemMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(DeliveryItem record) {
        return deliveryItemMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(DeliveryItem record) {
        return deliveryItemMapper.updateByPrimaryKey(record);
    }

    public List<DeliveryItem> listByDateTimeOrderByDateTime(DeliveryForm deliveryForm) {
        return deliveryItemMapper.listByDateTimeOrderByDateTime(deliveryForm);
    }

    public DeliveryItem getByDateTime(String dateTime) {
        return deliveryItemMapper.getByDateTime(dateTime);
    }
}
