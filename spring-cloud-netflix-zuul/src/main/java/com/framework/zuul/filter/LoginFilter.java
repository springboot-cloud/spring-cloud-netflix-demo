package com.framework.zuul.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @description: 登录验证拦截器
 * @author: XiongFeiYang
 * @createTime: 2019-08-18 20:23
 **/
@Component
public class LoginFilter extends ZuulFilter {

    /**
     * 配置过滤类型，有四种不同生命周期的过滤器类型
     * 1. pre：路由之前
     * 2. routing：路由之时
     * 3. post：路由之后
     * 4. error：发送错误调用
     *
     * @return String
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 配置过滤的顺序
     *
     * @return int
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 配置是否需要过滤：true/需要，false/不需要
     *
     * @return boolean
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体业务代码
     *
     * @return Object
     */
    @Override
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getHeader("token");
        // 认证通过
        if (!Strings.isNullOrEmpty(token)) {
            currentContext.setSendZuulResponse(true);
            currentContext.setResponseStatusCode(HttpStatus.OK.value());
            return null;
        }
        // 认证不通过
        currentContext.setSendZuulResponse(false);
        currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> paramsMap = Maps.newHashMap();
            paramsMap.put("code", HttpStatus.UNAUTHORIZED.value());
            paramsMap.put("msg", "请您先登录");
            paramsMap.put("data", null);
            HttpServletResponse contextResponse = currentContext.getResponse();
            contextResponse.setContentType("text/html;charset=UTF-8");
            contextResponse.getWriter().write(objectMapper.writeValueAsString(paramsMap));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
