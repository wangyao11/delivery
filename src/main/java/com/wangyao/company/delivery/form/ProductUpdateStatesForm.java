package com.wangyao.company.delivery.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author wy
 * @date 2019/10/17 0017
 * @description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductUpdateStatesForm {
    @NotNull
    private Long id;

    @NotNull
    @ApiModelProperty("0-启用 1-禁用")
    private Integer states;
}
