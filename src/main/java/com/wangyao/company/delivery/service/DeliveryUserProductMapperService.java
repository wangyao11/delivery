package com.wangyao.company.delivery.service;

import com.wangyao.company.delivery.dao.DeliveryUserProductMapperDao;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author wy
 * @date 2019/9/4 0004
 * @description:
 */
@Service
public class DeliveryUserProductMapperService{

    @Resource
    private DeliveryUserProductMapperDao deliveryUserProductMapperDao;


}
