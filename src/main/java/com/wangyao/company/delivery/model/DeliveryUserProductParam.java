package com.wangyao.company.delivery.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wy
 * @date 2019/9/11 0011
 * @description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryUserProductParam {
    private Long userId;
    private List<Long> deliveryItemIds;
    private Long productId;
    private Long deliveryItemId;
    private Long classType;
}
