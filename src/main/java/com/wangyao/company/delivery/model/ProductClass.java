package com.wangyao.company.delivery.model;

import java.util.Date;

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
public class ProductClass {
    /**
    * 分类Id
    */
    private Long id;

    /**
    * 分类名称
    */
    private String name;

    /**
    * 备注
    */
    private String remark;

    /**
    * 分类排序，从大到小
    */
    private Integer sort;

    /**
    * 记录创建时间
    */
    private Date createTime;

    /**
    * 记录更新时间
    */
    private Date updateTime;
}