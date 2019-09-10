package com.wangyao.company.delivery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * @Author hlq
 * @Date 2018/8/15
 * @Description: 分页对象
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="分页对象",description="分页返回值")
public class PageResult<T> {

    @ApiModelProperty("结果数据集")
    private List<T> list = Collections.EMPTY_LIST;

    @ApiModelProperty("总数")
    private int total;

}
