package com.wangyao.company.delivery.dao.mapper;
import org.apache.ibatis.annotations.Param;

import com.wangyao.company.delivery.model.DeliveryDayItem;
import com.wangyao.company.delivery.form.DeliveryDayTotalForm;
import com.wangyao.company.delivery.vo.DeliveryDayTotalVO;

import java.util.List;

/**
 * @author wy
 * @date 2019/12/21 0021
 * @description:
 */
public interface DeliveryDayItemMapper {
    int deleteById(Long id);

    int insert(DeliveryDayItem record);

    int insertSelective(DeliveryDayItem record);

    int insertList(@Param("list")List<DeliveryDayItem> list);

    DeliveryDayItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DeliveryDayItem record);

    int updateByPrimaryKey(DeliveryDayItem record);

    List<DeliveryDayTotalVO> listByUserIdAndDate(DeliveryDayTotalForm deliveryDayTotalForm);

    DeliveryDayItem getByUserIdAndProductIdAndDeliveryItemId(@Param("userId")Long userId,@Param("productId")Long productId,@Param("deliveryItemId")Long deliveryItemId);

    List<DeliveryDayItem> getByUserIdAndDeliveryItemId(@Param("userId")Long userId,@Param("deliveryItemId")Long deliveryItemId);


}