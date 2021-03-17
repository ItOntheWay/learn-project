package com.learn.shejimoshi.decorator;

/**
 * @author jingpb
 * @version 1.0
 * @date 2021/3/1 14:57
 *
 * 装饰器类，拓展Coffee类功能
 */
public abstract class CoffeeDecorator implements Coffee {
    protected final Coffee decoratorCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratorCoffee = coffee;
    }

    @Override
    public double getCost() {
        return decoratorCoffee.getCost();
    }

    @Override
    public String getIngredients() {
        return decoratorCoffee.getIngredients();
    }
}
