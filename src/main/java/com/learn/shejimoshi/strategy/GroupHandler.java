package com.learn.shejimoshi.strategy;

import org.springframework.stereotype.Component;

@Component
@HandlerType("2")
public class GroupHandler extends AbstractHandler {

    @Override
    public String handler(OrderDTO dto) {
        return "处理团购订单";
    }

}
