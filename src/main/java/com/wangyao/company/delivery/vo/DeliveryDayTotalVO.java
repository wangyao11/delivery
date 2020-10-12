package com.wangyao.company.delivery.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wy
 * @date 2019/12/21 0021
 * @description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDayTotalVO {
    private String productName;
    private String productType;
    private Integer classType;
    private Integer totalCount;
    private Integer totalPrice;
}
