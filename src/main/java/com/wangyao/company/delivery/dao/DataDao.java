package com.wangyao.company.delivery.dao;

import com.wangyao.company.delivery.dao.mapper.DataMapper;
import com.wangyao.company.delivery.vo.ProductSalesVO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wy
 * @date 2019/11/26 0026
 * @description:
 */
@Repository
public class DataDao {

    @Resource
    private DataMapper dataMapper;

    public List<ProductSalesVO> getProductSales() {
        return dataMapper.getProductSales();
    }
}
