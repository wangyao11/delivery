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
    * 产品销量
    */
    private int count;

    /**
    * 产品名称
    */
    private String productName;
}