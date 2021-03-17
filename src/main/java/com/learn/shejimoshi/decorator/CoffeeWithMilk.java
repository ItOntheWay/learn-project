package com.learn.shejimoshi.decorator;

/**
 * @author jingpb
 * @version 1.0
 * @date 2021/3/1 15:01
 */
public class CoffeeWithMilk extends CoffeeDecorator {
    public CoffeeWithMilk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        double additionalCost = 0.5;
        return super.getCost() + additionalCost;
    }

    @Override
    public String getIngredients() {

        return super.getIngredients()+", milk";
    }
}
