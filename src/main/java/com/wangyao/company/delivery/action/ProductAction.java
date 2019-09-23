package com.wangyao.company.delivery.action;

import com.wangyao.company.delivery.ResponseEntity;
import com.wangyao.company.delivery.dao.ProductDao;
import com.wangyao.company.delivery.exception.BusinessException;
import com.wangyao.company.delivery.form.ProductAddForm;
import com.wangyao.company.delivery.form.ProductForm;
import com.wangyao.company.delivery.form.ProductUpdateForm;
import com.wangyao.company.delivery.model.Product;
import com.wangyao.company.delivery.util.ValidationUtils;
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
 * @date 2019/9/7 0007
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/web/product")
@Api(value = "productAction", description = "商品")
public class ProductAction {
    @Resource
    private ProductDao productDao;

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

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ApiOperation(value = "添加商品", notes = "添加商品")
    ResponseEntity add(@RequestBody ProductAddForm productAddForm) throws BusinessException {
        ValidationUtils.validate(productAddForm);
        int isHa = productDao.countByName(productAddForm.getName());
        if (0 == isHa) {
            productDao.insertSelective(Product.builder()
                    .name(productAddForm.getName())
                    .classId(productAddForm.getClassId())
                    .remark(productAddForm.getRemark())
                    .price(productAddForm.getPrice())
                    .type(productAddForm.getType())
                    .build());
        } else {
            throw new BusinessException("添加失败,该产品已存在");
        }
        return new ResponseEntity();
    }

    @RequestMapping(value = "updateById", method = RequestMethod.POST)
    @ApiOperation(value = "修改商品", notes = "修改商品")
    ResponseEntity updateById(@RequestBody ProductUpdateForm productUpdateForm) throws BusinessException {
        ValidationUtils.validate(productUpdateForm);
        productDao.updateById(Product.builder()
                .id(productUpdateForm.getId())
                .name(productUpdateForm.getName())
                .classId(productUpdateForm.getClassId())
                .price(productUpdateForm.getPrice())
                .remark(productUpdateForm.getRemark())
                .type(productUpdateForm.getType())
                .build());
        return new ResponseEntity();
    }
}
