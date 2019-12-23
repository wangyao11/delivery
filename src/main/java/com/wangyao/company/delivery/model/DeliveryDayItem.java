package com.wangyao.company.delivery.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wy
 * @date 2019/12/21 0021
 * @description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDayItem {
    /**
    * 主键ID
    */
    private Long id;

    /**
    * 配送单Id
    */
    private Long deliveryItemId;

    /**
    * 用户
    */
    private Long userId;

    /**
    * 产品ID
    */
    private Long productId;

    /**
    * 产品数量
    */
    private Integer totalCount;

    /**
    * 产品总价
    */
    private Integer totalPrice;

    /**
    * 记录创建时间
    */
    private Date createTime;

    /**
    * 记录更新时间
    */
    private Date updateTime;
}