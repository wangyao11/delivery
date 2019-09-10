package com.wangyao.company.delivery.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
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
public class UserAddForm {

    @Size(max = 50)
    @NotBlank
    @ApiModelProperty("学校名称")
    private String name;

    @ApiModelProperty("账户")
    @Size(max = 50)
    @NotBlank
    private String account;

    @ApiModelProperty("密码")
    @Size(max = 50)
    private String password;

    @ApiModelProperty("备注")
    @Size(max = 100)
    private String remark;

    @ApiModelProperty("地址")
    @Size(max = 100)
    private String address;
}
