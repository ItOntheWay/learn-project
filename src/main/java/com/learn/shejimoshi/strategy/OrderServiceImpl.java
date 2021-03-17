package com.learn.shejimoshi.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private HandlerContext handlerContext;

    @Override
    public String handle(OrderDTO orderDTO) {
        AbstractHandler handler = handlerContext.getInstance(orderDTO.getType());
        return handler.handler(orderDTO);
    }
}
