package com.wangyao.company.delivery.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

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
    @NotNull
    private Long userId;
    @NotNull
    private Long productId;
    private Long deliveryItemId;
    @ApiModelProperty("无法获取deliveryTtemId时使用时间")
    private String dateTime;
    @NotNull
    private Integer count;
}
