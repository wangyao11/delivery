package com.wangyao.company.delivery.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 登录信息dto
 *
 * @author qingyan on 2018-05-22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminLoginForm {
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    @JsonProperty("user_name")
    @NotBlank
    @Size(max = 50)
    private String userName;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    @NotBlank
    @Size(max = 50)
    private String password;
}
