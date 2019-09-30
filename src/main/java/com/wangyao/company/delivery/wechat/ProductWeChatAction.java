package com.wangyao.company.delivery.wechat;

import com.wangyao.company.delivery.ResponseEntity;
import com.wangyao.company.delivery.dao.ProductClassDao;
import com.wangyao.company.delivery.dao.ProductDao;
import com.wangyao.company.delivery.form.ProductForm;
import com.wangyao.company.delivery.model.Product;
import com.wangyao.company.delivery.model.ProductClass;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private ProductClassDao productClassDao;
    @Resource
    private ProductDao productDao;

    @RequestMapping(value = "getClasslist", method = RequestMethod.POST)
    @ApiOperation(value = "查询所有商品分类", notes = "查询所有商品分类")
    ResponseEntity<List<ProductClass>> getClasslist() {
        List<ProductClass> productClassList = productClassDao.getOrderByCreateTimeDesc();
        ResponseEntity<List<ProductClass>> responseEntityBuilder = new ResponseEntity<>();
        responseEntityBuilder.setValue(productClassList);
        return responseEntityBuilder;
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ApiOperation(value = "查询所有商品", notes = "查询所有商品")
    ResponseEntity<List<Product>> list(
            @ApiParam(value = "查询所有商品", name = "pageParam") @RequestBody ProductForm productForm
    ) {
        List<Product> productList = productDao.listByForm(productForm);

        ResponseEntity<List<Product>> responseEntityBuilder = new ResponseEntity<>();
        responseEntityBuilder.setValue(productList);
        return responseEntityBuilder;
    }
}
