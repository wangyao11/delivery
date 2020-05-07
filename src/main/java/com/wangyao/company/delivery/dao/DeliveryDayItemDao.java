package com.wangyao.company.delivery.dao;

import com.wangyao.company.delivery.dao.mapper.DeliveryDayItemMapper;
import com.wangyao.company.delivery.form.DeliveryDayTotalForm;
import com.wangyao.company.delivery.model.DeliveryDayItem;
import com.wangyao.company.delivery.vo.DeliveryDayTotalVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wy
 * @date 2019/12/21 0021
 * @description:
 */
@Repository
public class DeliveryDayItemDao {
    @Resource
    private DeliveryDayItemMapper deliveryDayItemMapper;

    public int insertList(List<DeliveryDayItem> list) {
        return deliveryDayItemMapper.insertList(list);
    }

    public List<DeliveryDayTotalVO> listByUserIdAndDate(DeliveryDayTotalForm deliveryDayTotalForm) {
        return deliveryDayItemMapper.listByUserIdAndDate(deliveryDayTotalForm);
    }

    public DeliveryDayItem getByUserIdAndProductIdAndDeliveryItemId(Long userId, Long productId, Long deliveryItemId) {
        return deliveryDayItemMapper.getByUserIdAndProductIdAndDeliveryItemId(userId, productId, deliveryItemId);
    }

    public List<DeliveryDayItem> getByUserIdAndDeliveryItemId(Long userId, Long deliveryItemId) {
        return deliveryDayItemMapper.getByUserIdAndDeliveryItemId(userId, deliveryItemId);
    }

    public int deleteBydeliveryItemId(Long deliveryItemId) {
        return deliveryDayItemMapper.deleteByDeliveryItemId(deliveryItemId);
    }

    public int deleteById(Long id) {
        return deliveryDayItemMapper.deleteById(id);
    }
}
