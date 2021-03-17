package com.learn.shejimoshi.decorator;

/**
 * @author jingpb
 * @version 1.0
 * @date 2021/3/1 14:53
 *
 * 手撕 装饰器模式
 * https://www.cnblogs.com/yxlaisj/p/10446504.html
 * 装饰器模式(Decorator Pattern)，动态地给一个对象添加一些额外的职责，就增加功能来说，装饰器模式比生成子类更灵活.----《大话设计模式》
 */
public class DecoratorDemo {

    static void print(Coffee coffee){
        System.out.println("花费:"+coffee.getCost());
        System.out.println("配料:"+coffee.getIngredients());
    }

    public static void main(String[] args) {
        /*Coffee c = new SimpleCoffee();
        print(c);

        Coffee c1 = new CoffeeWithMilk(c);
        print(c1);

        Coffee c2 = new CoffeeWithSugar(c);
        print(c2);

        Coffee c3 = new CoffeeWithSugar(c1);
        print(c3);*/
        Coffee c = new SimpleCoffee();
        print(c);

        c = new CoffeeWithMilk(c);
        print(c);

        c = new CoffeeWithSugar(c);
        print(c);

    }


}
