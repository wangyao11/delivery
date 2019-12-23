package com.wangyao.company.delivery.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author wy
 * @date 2019/9/16 0016
 * @description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryUserProductSaveForm {
    @NotNull
    private Long userId;
    private Long deliveryItemId;
    @ApiModelProperty("无法获取deliveryTtemId时使用时间")
    private String dateTime;
    private List<DeliverySaveItemForm> values;
}
