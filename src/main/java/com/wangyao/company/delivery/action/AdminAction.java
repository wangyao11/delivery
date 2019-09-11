package com.wangyao.company.delivery.action;

import com.wangyao.company.delivery.ResponseEntity;
import com.wangyao.company.delivery.dao.AdminDao;
import com.wangyao.company.delivery.exception.BusinessException;
import com.wangyao.company.delivery.form.AdminLoginForm;
import com.wangyao.company.delivery.model.Admin;
import com.wangyao.company.delivery.util.JwtUtil;
import com.wangyao.company.delivery.util.Md5Util;
import com.wangyao.company.delivery.util.ValidationUtils;
import com.wangyao.company.delivery.vo.AdminLoginSuccessVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2019/9/7 0007
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/web/admin")
@Api(value = "adminAction", description = "管理员")
public class AdminAction {

    @Resource
    private AdminDao adminDao;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ApiOperation(value = "登录", notes = "登录")
    public ResponseEntity<AdminLoginSuccessVO> login(@ApiParam(value = "登录信息", name = "loginInfo") @RequestBody AdminLoginForm adminLoginForm) {
        ValidationUtils.validate(adminLoginForm);
        String md5Password = Md5Util.md5Password(adminLoginForm.getPassword());

        Admin admin = adminDao.getByAccountAndPassword(adminLoginForm.getUserName(), md5Password);

        if (admin == null) {
            throw new BusinessException("用户名或密码错误!");
        }

        Map<String, Object> payload = new HashMap<>(4);
        Date date = new Date();
        // 用户id
        payload.put("adminId", admin.getId());
        // 生成时间:当前
        payload.put("createTime", date.getTime());
        // 过期时间为7天
        payload.put("ext", date.getTime() + 7 * 24  * 1000 * 60 * 60);

        String token = JwtUtil.createToken(payload);

        AdminLoginSuccessVO loginSuccessVO = AdminLoginSuccessVO.builder()
                .id(admin.getId())
                .name(admin.getName())
                .token(token).build();

        ResponseEntity<AdminLoginSuccessVO> responseEntityBuilder = new ResponseEntity<>();
        responseEntityBuilder.setValue(loginSuccessVO);

        return responseEntityBuilder;
    }
}
