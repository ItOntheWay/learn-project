package com.learn.shejimoshi.strategy;

import org.springframework.stereotype.Component;

@Component
@HandlerType("3")
public class PromotionHandler extends AbstractHandler {

    @Override
    public String handler(OrderDTO dto) {
        return "处理促销订单";
    }

}