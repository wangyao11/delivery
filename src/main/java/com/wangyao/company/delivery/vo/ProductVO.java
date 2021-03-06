package com.wangyao.company.delivery.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author wy
 * @date 2019/9/4 0004
 * @description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO {
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
     * 备注
     */
    private String remark;

    private float price;

    /**
     * 状态:0-上架,1-下架
     */
    private Byte states;

    /**
     * 商品类型 0-斤 1-袋 2-瓶 3-桶 4-包
     */
    private String type;

    /**
     * 分类排序，从大到小
     */
    private Integer sort;

    private int count;

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