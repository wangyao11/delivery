package com.wangyao.company.delivery.form;

import io.swagger.models.auth.In;
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
public class DeliveryDayTotalForm {
    private Long userId;

    private String startTime;

    private String endTime;

    private Integer classType;
}
