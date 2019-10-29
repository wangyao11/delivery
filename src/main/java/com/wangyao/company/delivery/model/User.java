package com.wangyao.company.delivery.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wy
 * @date 2019/9/4 0004
 * @description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
    * 主键ID
    */
    private Long id;

    /**
    * 账户名称
    */
    private String name;

    /**
    * 登录账户
    */
    private String account;

    /**
    * 密码
    */
    private String password;

    /**
    * 状态:0-启用,1-禁用
    */
    private Integer states;

    /**
    * 用户备注
    */
    private String remark;

    /**
    * 用户地址
    */
    private String address;

    private String number;

    /**
    * 记录创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
    * 记录更新时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
}