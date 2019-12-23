package com.wangyao.company.delivery.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.wangyao.company.delivery.model.DeliveryDayItem;
import com.wangyao.company.delivery.dao.mapper.DeliveryDayItemMapper;
/**
 * @author wy
 * @date 2019/12/21 0021
 * @description:
 */
@Service
public class DeliveryDayItemService{

    @Resource
    private DeliveryDayItemMapper deliveryDayItemMapper;

    
    public int deleteById(Long id) {
        return deliveryDayItemMapper.deleteById(id);
    }

    
    public int insert(DeliveryDayItem record) {
        return deliveryDayItemMapper.insert(record);
    }

    
    public int insertSelective(DeliveryDayItem record) {
        return deliveryDayItemMapper.insertSelective(record);
    }

    
    public DeliveryDayItem selectByPrimaryKey(Long id) {
        return deliveryDayItemMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(DeliveryDayItem record) {
        return deliveryDayItemMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(DeliveryDayItem record) {
        return deliveryDayItemMapper.updateByPrimaryKey(record);
    }

}
