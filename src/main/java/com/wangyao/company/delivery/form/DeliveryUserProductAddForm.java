package com.wangyao.company.delivery.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wy
 * @date 2019/9/16 0016
 * @description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryUserProductAddForm {
    private Long userId;
    private Long productId;
    private Long deliveryItemId;
    private Integer count;
}
