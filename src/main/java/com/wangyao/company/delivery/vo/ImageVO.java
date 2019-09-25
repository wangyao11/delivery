package com.wangyao.company.delivery.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * 图片dto
 *
 * @author qingyan on 2018-05-04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@ApiModel(value = "图片")
public class ImageVO {

    /**
     * 图片
     */
    @ApiModelProperty(value = "图片")
    @NotNull
    private String image;
}
