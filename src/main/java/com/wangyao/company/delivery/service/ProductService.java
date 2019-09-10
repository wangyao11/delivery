package com.wangyao.company.delivery.service;

import com.wangyao.company.delivery.dao.ProductDao;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author wy
 * @date 2019/9/4 0004
 * @description:
 */
@Service
public class ProductService{

    @Resource
    private ProductDao productDao;

}
