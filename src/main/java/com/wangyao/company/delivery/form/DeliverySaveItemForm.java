package com.wangyao.company.delivery.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wy
 * @date 2019/12/22 0022
 * @description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliverySaveItemForm {
    private Double totalPrice;
    private Integer totalCount;
    private Long productId;
}
