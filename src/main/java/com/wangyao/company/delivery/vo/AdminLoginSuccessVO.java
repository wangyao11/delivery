package com.wangyao.company.delivery.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * Author wy
 * Date 2018/8/14 0014
 * Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("登录成功返回值")
public class AdminLoginSuccessVO {
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Long id;

    /**
     * token
     */
    @ApiModelProperty("token")
    private String token;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    @JsonProperty("name")
    private String name;
}
