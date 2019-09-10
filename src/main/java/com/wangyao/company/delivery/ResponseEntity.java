package com.wangyao.company.delivery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Author wy
 * Date 2018/8/20 0020
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value="返回值对象",description="返回值")
public class ResponseEntity<T> {
    @ApiModelProperty("状态码")
    private int code = 200;

    @ApiModelProperty("返回值消息")
    private String message = "操作成功";

    @ApiModelProperty("返回值")
    private T value;

    @ApiModelProperty("操作时间")
    private Date timestamp = new Date();

    public ResponseEntity(T value) {
        this.value = value;
    }
}
