package com.learn;

import com.learn.jichu.PinType;
import com.learn.jichu.Pizza;
import com.learn.jichu.PizzaStatus;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static junit.framework.TestCase.assertTrue;

@SpringBootTest
public class EnumTest {

    @Test
    public void givenPizaOrder_whenDelivered_thenPizzaGetsDeliveredAndStatusChanges() {
        Pizza pz = new Pizza();
        pz.setStatus(PizzaStatus.READY);
        pz.deliver();
        assertTrue(pz.getStatus() == PizzaStatus.DELIVERED);
    }

    @Test
    public void enumTest(){
        System.out.println(PinType.getMsg(100000));
        System.out.println(PinType.getCode("注册使用!"));
    }

}
