package com.wangyao.company.delivery.action;

import com.wangyao.company.delivery.ResponseEntity;
import com.wangyao.company.delivery.dao.ProductClassDao;
import com.wangyao.company.delivery.exception.BusinessException;
import com.wangyao.company.delivery.form.ProductClassAddForm;
import com.wangyao.company.delivery.model.ProductClass;
import com.wangyao.company.delivery.util.ValidationUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/web/productClass")
@Api(value = "productClassAction", description = "商品分类")
public class ProductClassAction {
    @Resource
    private ProductClassDao productClassDao;

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ApiOperation(value = "查询所有商品分类", notes = "查询所有商品分类")
    ResponseEntity<List<ProductClass>> list() {
        List<ProductClass> productClassList = productClassDao.getOrderByCreateTimeDesc();
        ResponseEntity<List<ProductClass>> responseEntityBuilder = new ResponseEntity<>();
        responseEntityBuilder.setValue(productClassList);
        return responseEntityBuilder;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ApiOperation(value = "添加商品分类", notes = "添加商品分类")
    ResponseEntity add(@RequestBody ProductClassAddForm productClassAddForm) throws BusinessException {
        ValidationUtils.validate(productClassAddForm);
        int isHa = productClassDao.countByName(productClassAddForm.getName());
        if (0 == isHa) {
            productClassDao.insertSelective(ProductClass.builder()
                    .name(productClassAddForm.getName())
                    .remark(productClassAddForm.getRemark())
                    .build());
        } else {
            throw new BusinessException("添加失败,该产品分类已存在");
        }
        return new ResponseEntity();
    }
}
