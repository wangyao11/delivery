package com.wangyao.company.delivery.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.wangyao.company.delivery.dao.mapper.ProductClassMapper;
/**
 * @author wy
 * @date 2019/9/4 0004
 * @description:
 */
@Service
public class ProductClassService{

    @Resource
    private ProductClassMapper productClassMapper;

}
