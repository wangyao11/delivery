package com.wangyao.company.delivery.wechat;

import com.wangyao.company.delivery.ResponseEntity;
import com.wangyao.company.delivery.dao.UserDao;
import com.wangyao.company.delivery.exception.BusinessException;
import com.wangyao.company.delivery.form.UserLoginForm;
import com.wangyao.company.delivery.model.User;
import com.wangyao.company.delivery.util.JwtUtil;
import com.wangyao.company.delivery.util.Md5Util;
import com.wangyao.company.delivery.util.ValidationUtils;
import com.wangyao.company.delivery.vo.UserLoginSuccessVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
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
 * @date 2019/9/25 0025
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/wechat/user")
@Api(value = "UserWeChatAction", description = "用户")
public class UserWeChatAction {
    @Resource
    private UserDao userDao;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ApiOperation(value = "登录", notes = "登录")
    public ResponseEntity<UserLoginSuccessVO> login(@ApiParam(value = "登录信息", name = "loginInfo") @RequestBody UserLoginForm userLoginForm) {
        ValidationUtils.validate(userLoginForm);
        String md5Password = Md5Util.md5Password(userLoginForm.getPassword());

        User user = userDao.getByAccountAndPassword(userLoginForm.getUserName(), md5Password);

        if (user == null) {
            throw new BusinessException("用户名或密码错误!");
        }

        Map<String, Object> payload = new HashMap<>(4);
        Date date = new Date();
        // 用户id
        payload.put("userId", user.getId());
        // 生成时间:当前
        payload.put("createTime", date.getTime());
        // 过期时间为7天
        payload.put("ext", date.getTime() + 7 * 24  * 1000 * 60 * 60);

        String token = JwtUtil.createToken(payload);

        UserLoginSuccessVO loginSuccessVO = UserLoginSuccessVO.builder()
                .id(user.getId())
                .name(user.getName())
                .token(token).build();

        ResponseEntity<UserLoginSuccessVO> responseEntityBuilder = new ResponseEntity<>();
        responseEntityBuilder.setValue(loginSuccessVO);

        return responseEntityBuilder;
    }
}
