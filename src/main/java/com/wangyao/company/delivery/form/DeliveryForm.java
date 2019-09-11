package com.wangyao.company.delivery.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wy
 * @date 2019/9/10 0010
 * @description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryForm {
    @ApiModelProperty("时间格式 yyyy-MM-dd")
    private String startTime;

    @ApiModelProperty("时间格式 yyyy-MM-dd")
    private String endTime;
}
