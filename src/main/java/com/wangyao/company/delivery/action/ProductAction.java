package com.wangyao.company.delivery.action;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wy
 * @date 2019/9/7 0007
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/web/product")
@Api(value = "productAction", description = "商品")
public class ProductAction {
}
