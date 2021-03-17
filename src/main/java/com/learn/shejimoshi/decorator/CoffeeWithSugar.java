package com.learn.shejimoshi.decorator;

/**
 * @author jingpb
 * @version 1.0
 * @date 2021/3/1 15:04
 */
public class CoffeeWithSugar extends CoffeeDecorator{
    public CoffeeWithSugar(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost(){
        double additionalCost = 1;
        return super.getCost()+additionalCost;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients()+", Sugar";
    }
}
