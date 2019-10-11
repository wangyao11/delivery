package com.wangyao.company.delivery.service;

import com.wangyao.company.delivery.dao.DeliveryItemDao;
import com.wangyao.company.delivery.form.DeliveryForm;
import com.wangyao.company.delivery.model.DeliveryItem;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author wy
 * @date 2019/9/4 0004
 * @description:
 */
@Service
public class DeliveryItemService{

    @Resource
    private DeliveryItemDao deliveryItemDao;

    public List<DeliveryItem> list(DeliveryForm deliveryForm){
        return deliveryItemDao.listByDateTimeOrderByDateTime(deliveryForm);
    }

    public List<DeliveryItem> oldList(DeliveryForm deliveryForm){
        return deliveryItemDao.listByDateTimeOrderByDateTimeDesc(deliveryForm);
    }
}
