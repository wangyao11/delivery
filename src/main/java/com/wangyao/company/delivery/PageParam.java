package com.wangyao.company.delivery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author hlq
 * @Date 2018/8/15
 * @Description: 分页参数对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="分页参数对象",description="分页参数值")
public class PageParam<T> {
    private T condition;

    @ApiModelProperty("查询起始数")
    private int start;

    @ApiModelProperty("每页显示数量")
    private int size;
}
