package com.wangyao.company.delivery.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wy
 * @date 2019/11/26 0026
 * @description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductSalesVO {
    private int productNum;
    private String productName;
}
