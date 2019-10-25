package com.wangyao.company.delivery.config;

import com.wangyao.company.delivery.enums.TokenStatus;
import com.wangyao.company.delivery.util.JwtUtil;
import com.wangyao.company.delivery.vo.TokenVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author wy
 * @ate 2018/8/24
 * @Description: 登录权限拦截
 */
@Component
@Slf4j
public class SecurityInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        String token = "";
        log.info("进入拦截器");

        token = String.valueOf(httpServletRequest.getHeader("Authorization"));

        log.info("token" + token);
        // 未登录的请求拦截
        if (StringUtils.isEmpty(token) || "null".equals(token)) {
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "未登录");
            return false;
        }

        TokenVO resultMap = JwtUtil.validToken(token);
        // token认证失败的请求验证
        if(resultMap.getState() == TokenStatus.INVALID.getValue()){
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "用户认证失败");
            return false;
        }

        // token 超时
        if(resultMap.getState() ==  TokenStatus.EXPIRED.getValue()){
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "登录时间超时,请重新登录");
            return false;
        }
        Map<String, Object> userMap = (Map<String, Object>)resultMap.getCondition();
        httpServletRequest.setAttribute("userId", userMap.get("userId"));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
