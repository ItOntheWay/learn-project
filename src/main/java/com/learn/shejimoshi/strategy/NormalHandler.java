package com.learn.shejimoshi.strategy;

import org.springframework.stereotype.Component;

@Component
@HandlerType("1")
public class NormalHandler extends AbstractHandler {

    @Override
    public String handler(OrderDTO dto) {
        return "处理普通订单";
    }
}
