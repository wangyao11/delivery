package com.wangyao.company.delivery.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Author wy
 * Date 2018/10/10 0010
 * Description:
 */
@AllArgsConstructor
@Getter
public enum TokenStatus {
    /**
     * 已过期
     */
    EXPIRED(2, "token不合法"),
    /**
     * 无效(token不合法)
     */
    INVALID(1, "无效的token"),
    /**
     * 有效的
     */
    VALID(0, "有效的");

    private int value;
    private String describe;
}
