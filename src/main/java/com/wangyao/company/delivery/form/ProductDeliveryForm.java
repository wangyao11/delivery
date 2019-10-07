package com.wangyao.company.delivery.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author wy
 * @date 2019/9/10 0010
 * @description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDeliveryForm {

    @ApiModelProperty("配送单Id")
    @NonNull
    private Long deliveryItemId;

    @ApiModelProperty("用户Id")
    @NonNull
    private Long userId;
}
