package com.wangyao.company.delivery.action;

import com.wangyao.company.delivery.PageResult;
import com.wangyao.company.delivery.ResponseEntity;
import com.wangyao.company.delivery.exception.BusinessException;
import com.wangyao.company.delivery.form.ProductUpdateForm;
import com.wangyao.company.delivery.form.UserAddForm;
import com.wangyao.company.delivery.form.UserForm;
import com.wangyao.company.delivery.form.UserUpdateForm;
import com.wangyao.company.delivery.model.Product;
import com.wangyao.company.delivery.model.User;
import com.wangyao.company.delivery.service.UserService;
import com.wangyao.company.delivery.util.Md5Util;
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

/**
 * @author wy
 * @date 2019/9/7 0007
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/web/user")
@Api(value = "userAction", description = "用户")
public class UserAction {

    @Resource
    private UserService userService;

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ApiOperation(value = "分页查询所有用户", notes = "分页查询所有用户")
    ResponseEntity<PageResult<User>> list(
            @ApiParam(value = "查询所有用户", name = "pageParam") @RequestBody UserForm userForm
    ) {
        PageResult<User> pageResult = new PageResult<>();

        int count = userService.counts(userForm);
        if (count > 0) {
            pageResult.setList(userService.list(userForm));
        }

        pageResult.setTotal(count);

        ResponseEntity<PageResult<User>> responseEntityBuilder = new ResponseEntity<>();
        responseEntityBuilder.setValue(pageResult);
        return responseEntityBuilder;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ApiOperation(value = "添加学校", notes = "添加学校")
    ResponseEntity add(@RequestBody UserAddForm userAddForm) throws BusinessException {
        ValidationUtils.validate(userAddForm);
        int isHa = userService.countByAccount(userAddForm.getAccount());
        int isHas = userService.countByName(userAddForm.getName());
        if (0 == isHa && 0 == isHas) {
            userService.add(User.builder()
                    .account(userAddForm.getAccount())
                    .address(userAddForm.getAddress())
                    .name(userAddForm.getName())
                    .number(userAddForm.getNumber())
                    .password(Md5Util.md5Password(userAddForm.getPassword()))
                    .remark(userAddForm.getRemark())
                    .states(0).build());
        } else {
            throw new BusinessException("添加失败,该学校已存在");
        }
        return new ResponseEntity();
    }

    @RequestMapping(value = "updateById", method = RequestMethod.POST)
    @ApiOperation(value = "修改学校信息", notes = "修改学校信息")
    ResponseEntity updateById(@RequestBody UserUpdateForm userUpdateForm) throws BusinessException {
        ValidationUtils.validate(userUpdateForm);
        userService.updateById(User.builder()
                .id(userUpdateForm.getId())
                .name(userUpdateForm.getName())
                .account(userUpdateForm.getAccount())
                .number(userUpdateForm.getNumber())
                .remark(userUpdateForm.getRemark())
                .address(userUpdateForm.getAddress())
                .build());
        return new ResponseEntity();
    }
}
