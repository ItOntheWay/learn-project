package com.learn.shejimoshi.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private OrderService  orderService;

    @RequestMapping("/test")
    public String test(String type){
        OrderDTO dto1 = Builder.of(OrderDTO::new)
                .with(OrderDTO::setCode,"s0001")
                .with(OrderDTO::setType,type)
                .build();
        String res = orderService.handle(dto1);
        return res;
    }

}
