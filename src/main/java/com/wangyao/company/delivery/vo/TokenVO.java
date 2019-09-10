package com.wangyao.company.delivery.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author wy
 * Date 2018/10/10 0010
 * Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenVO<T> {
    private T condition;

    private Integer state;
}
