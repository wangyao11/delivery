package com.wangyao.company.delivery.model;

import java.util.Date;
import lombok.Data;

/**
 * @author wy
 * @date 2019/9/4 0004
 * @description:
 */
@Data
public class DeliveryItem {
    /**
    * 配送区间id
    */
    private Long id;

    /**
    * 配送区间时间点 2019-09-04
    */
    private Date dateTime;

    /**
    * 状态:0-启用,1-禁用
    */
    private Byte states;

    /**
    * 备注
    */
    private String remark;

    /**
    * 记录创建时间
    */
    private Date createTime;

    /**
    * 记录更新时间
    */
    private Date updateTime;
}