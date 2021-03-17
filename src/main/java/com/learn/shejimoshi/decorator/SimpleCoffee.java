package com.learn.shejimoshi.decorator;

/**
 * @author jingpb
 * @version 1.0
 * @date 2021/3/1 14:56
 */
public class SimpleCoffee implements Coffee {

    @Override
    public double getCost() {
        return 1;
    }

    @Override
    public String getIngredients() {
        return "Coffee";
    }
}
