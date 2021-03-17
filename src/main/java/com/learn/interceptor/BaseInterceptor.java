package com.learn.interceptor;

import com.alibaba.fastjson.JSON;
import com.learn.common.Result;
import com.learn.common.ResultCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class BaseInterceptor extends HandlerInterceptorAdapter {
    private static final Logger log = LoggerFactory.getLogger(BaseInterceptor.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
        String sign = request.getHeader("sign");
        if(!sign.equalsIgnoreCase("123")){
            getResponse(new Result(ResultCodeEnum.FAIL_SIGN),response);
            return false;
        }
        log.info("请求地址path:{},参数:{}",request.getRequestURI(),sign);
        return super.preHandle(request, response, handler);
    }

    /**
     * 构造响应消息体
     *
     * @param result
     * @param response
     * @throws IOException
     */
    private void getResponse(Result result, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        PrintWriter out = null;
        out = response.getWriter();
        out.write(JSON.toJSONString(result));
        out.flush();
        out.close();
    }
}
