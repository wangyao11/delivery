package com.wangyao.company.delivery.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author wy
 * @date 2019/9/10 0010
 * @description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductUpdateForm {

    @NotNull
    private Long id;

    @Size(max = 50)
    @NotBlank
    @ApiModelProperty("产品名称")
    private String name;

    @NotNull
    @ApiModelProperty("类别Id")
    private Long classId;

    @ApiModelProperty("备注")
    @Size(max = 100)
    private String remark;

    @NotNull
    private float price;

    private Integer sort;

    private Integer classType;

    @NotNull
    @ApiModelProperty("商品类型 0-斤 1-袋 2-瓶 3-桶 4-包 5-个 6-件")
    private String type;

    @ApiModelProperty("图片路径")
    private String imageUrl;

    @ApiModelProperty("生产日期")
    private String manufactureDate;

    @ApiModelProperty("保质日期")
    private String guaranteeDate;
}
