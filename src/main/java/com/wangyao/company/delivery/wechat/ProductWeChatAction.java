package com.wangyao.company.delivery.wechat;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wy
 * @date 2019/9/25 0025
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/wechat/product")
@Api(value = "ProductWeChatAction", description = "微信商品列表")
public class ProductWeChatAction {

}
