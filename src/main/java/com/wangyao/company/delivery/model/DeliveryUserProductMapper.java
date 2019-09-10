package com.wangyao.company.delivery.model;

import java.util.Date;
import lombok.Data;

/**
 * @author wy
 * @date 2019/9/4 0004
 * @description:
 */
@Data
public class DeliveryUserProductMapper {
    /**
    * 主键ID
    */
    private Long id;

    /**
    * 配送单Id
    */
    private Date deliveryItemId;

    /**
    * 用户
    */
    private Byte userId;

    /**
    * 产品ID
    */
    private Byte productId;

    /**
    * 产品数量
    */
    private Integer totalCount;

    /**
    * 记录创建时间
    */
    private Date createTime;

    /**
    * 记录更新时间
    */
    private Date updateTime;
}