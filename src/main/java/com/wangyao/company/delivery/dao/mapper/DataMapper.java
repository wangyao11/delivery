package com.wangyao.company.delivery.dao.mapper;

import com.wangyao.company.delivery.vo.ProductSalesVO;

import java.util.List;

/**
 * @author wy
 * @date 2019/11/26 0026
 * @description:
 */
public interface DataMapper {
    List<ProductSalesVO> getProductSales();
}
