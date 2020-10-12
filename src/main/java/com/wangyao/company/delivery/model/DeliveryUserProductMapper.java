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
public class DeliveryUserProductMapper {
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
     * 用户名
     */
    private String userName;

    /**
    * 产品ID
    */
    private Long productId;

    private Float productPrice;

    private Integer classType;

    /**
    * 产品数量
    */
    private Integer totalCount;

    /**
     * 产品名称
     */
    private String productName;

    private String productType;

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