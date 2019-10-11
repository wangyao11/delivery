package com.wangyao.company.delivery.dao.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import com.wangyao.company.delivery.form.DeliveryForm;
import java.util.List;

import com.wangyao.company.delivery.model.DeliveryItem;

/**
 * @author wy
 * @date 2019/9/4 0004
 * @description:
 */
public interface DeliveryItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DeliveryItem record);

    int insertSelective(DeliveryItem record);

    DeliveryItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DeliveryItem record);

    int updateByPrimaryKey(DeliveryItem record);

    List<DeliveryItem> listByDateTimeOrderByDateTime(DeliveryForm deliveryForm);

    List<DeliveryItem> listByDateTimeOrderByDateTimeDesc(DeliveryForm deliveryForm);

    DeliveryItem getByDateTime(@Param("dateTime") String dateTime);
}