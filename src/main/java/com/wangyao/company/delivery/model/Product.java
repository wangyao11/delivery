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
public class Product {
    /**
    * 产品Id
    */
    private Long id;

    /**
    * 产品名称
    */
    private String name;

    /**
    * 产品图片
    */
    private String imageUrl;

    /**
    * 分类Id
    */
    private Long classId;

    /**
     * 0 - 干货 1- 生鲜
     */
    private Integer classType;

    /**
    * 备注
    */
    private String remark;

    private float price;

    /**
    * 状态:0-上架,1-下架
    */
    private Integer states;

    /**
    * 商品类型 0-斤 1-袋 2-瓶 3-桶 4-包
    */
    private String type;

    /**
    * 分类排序，从大到小
    */
    private Integer sort;

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