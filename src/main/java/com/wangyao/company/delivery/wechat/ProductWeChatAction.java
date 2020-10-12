package com.wangyao.company.delivery.wechat;

import com.wangyao.company.delivery.ResponseEntity;
import com.wangyao.company.delivery.dao.DeliveryUserProductMapperDao;
import com.wangyao.company.delivery.dao.ProductClassDao;
import com.wangyao.company.delivery.dao.ProductDao;
import com.wangyao.company.delivery.form.ProductDeliveryForm;
import com.wangyao.company.delivery.form.ProductForm;
import com.wangyao.company.delivery.model.DeliveryUserProductMapper;
import com.wangyao.company.delivery.model.DeliveryUserProductParam;
import com.wangyao.company.delivery.model.Product;
import com.wangyao.company.delivery.model.ProductClass;
import com.wangyao.company.delivery.util.ValidationUtils;
import com.wangyao.company.delivery.vo.ProductVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
    @Resource
    private DeliveryUserProductMapperDao deliveryUserProductMapperDao;

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
    ResponseEntity<List<ProductVO>> list(
            @ApiParam(value = "查询所有商品", name = "pageParam") @RequestBody ProductDeliveryForm productDeliveryForm
    ) {
        ValidationUtils.validate(productDeliveryForm);
        List<Product> productList = productDao.listByForm(ProductForm.builder().states(0).build());

        List<ProductVO> productVOS = productList.stream().map(product -> {
            ProductVO productVO = new ProductVO();
            BeanUtils.copyProperties(product, productVO);
            DeliveryUserProductParam deliveryUserProductParam = DeliveryUserProductParam.builder()
                    .userId(productDeliveryForm.getUserId())
                    .deliveryItemId(productDeliveryForm.getDeliveryItemId())
                    .productId(product.getId()).build();
            DeliveryUserProductMapper deliveryUserProductMapper = deliveryUserProductMapperDao.getByUserIdAndProductIdAndDeliveryItemId(deliveryUserProductParam);
            if (Objects.nonNull(deliveryUserProductMapper)) {
                productVO.setCount(deliveryUserProductMapper.getTotalCount());
            }
            return productVO;
        }).collect(Collectors.toList());

        ResponseEntity<List<ProductVO>> responseEntityBuilder = new ResponseEntity<>();
        responseEntityBuilder.setValue(productVOS);
        return responseEntityBuilder;
    }
}
