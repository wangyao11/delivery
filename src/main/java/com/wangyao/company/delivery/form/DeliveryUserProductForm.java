package com.wangyao.company.delivery.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author wy
 * @date 2019/9/11 0011
 * @description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryUserProductForm {
    private Long userId;
    @NotBlank
    private String startTime;
    private String endTime;
    private Long deliveryItemId;
    private Long classType;
    private Long productId;
}
