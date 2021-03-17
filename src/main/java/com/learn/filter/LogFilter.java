package com.learn.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebFilter(filterName = "logFilter", urlPatterns = "/*")
public class LogFilter implements Filter {

    private final static Logger logger = LoggerFactory.getLogger(LogFilter.class);
    private ThreadLocal<Long> threadLocal = new ThreadLocal<>();


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 包装request和response
//        RequestWrapper requestWrapper = new RequestWrapper((HttpServletRequest) servletRequest);
        ResponseWrapper responseWrapper = new ResponseWrapper((HttpServletResponse) servletResponse);
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String request = JSON.toJSONString(req.getParameterMap());
        JSONObject json =  JSON.parseObject(request);
        /*Map<String, String[]> parameterMap = servletRequest.getParameterMap();
        JSONObject jsons = new JSONObject();
        for(String paramName : parameterMap.keySet()){
            String[] paramValue = (String[])parameterMap.get(paramName);
            jsons.fluentPut(paramName,paramValue[0]);
        }
        logger.info("---parama={}",jsons.toJSONString());*/
        // 获取request的相关数据
        /*logger.info("请求URL : " + requestWrapper.getRequestURL().toString());
        logger.info("请求参数 : " + requestWrapper.getBody());*/
        threadLocal.set(System.currentTimeMillis());
        logger.info("请求URL : " + req.getRequestURI());
        logger.info("请求参数 : " + json);
        filterChain.doFilter(servletRequest, responseWrapper);
        // 获取response的相关数据
        logger.info("响应数据 : " + new String(responseWrapper.getContent(), "UTF-8"));
        logger.info("请求处理时间 : " + (System.currentTimeMillis() - threadLocal.get()) + "ms");
        // 在得到响应的数据之后，response的输出流中就无可用的数据，所以需要巴数据放回去
        ServletOutputStream outputStream = servletResponse.getOutputStream();
        outputStream.write(responseWrapper.getContent());
        outputStream.flush();
        outputStream.close();
    }
}
