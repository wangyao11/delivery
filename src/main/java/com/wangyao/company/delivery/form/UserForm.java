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
public class UserForm {
    @ApiModelProperty("学校名称")
    private String name;

    @ApiModelProperty("查询起始数")
    private int start;

    @ApiModelProperty("每页显示数量")
    private int size;
}
