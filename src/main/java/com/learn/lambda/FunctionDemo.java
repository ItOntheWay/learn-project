package com.learn.lambda;


import java.util.function.Function;

/**
 * @author jpb
 * @version 1.0
 * @date 2021/3/19 17:30
 *
 * java8函数式接口 function
 * 它代表的含义是“函数”，而函数经常是有输入输出的，因此它含有一个apply方法，包含一个输入与一个输出；
 * 除apply方法外，它还有compose与andThen及indentity三个方法，
 */
public class FunctionDemo {

    public static void main(String[] args) {
        //apply
        Function<Integer,Integer> f = s -> ++s;
        Function<Integer,Integer> g = s-> s*2;
        /**
         * 下面表示在执行F时，先执行G，并且执行F时使用G的输出当作输入。
         * 相当于以下代码：
         * Integer a = g.apply(1);
         * System.out.println(f.apply(a));
         */
//        System.out.println(f.compose(g).apply(1));

        /**
         * 表示执行F的Apply后使用其返回的值当作输入再执行G的Apply；
         * 相当于以下代码
         */
//        System.out.println(f.andThen(g).apply(1));
        /**
         * identity方法会返回一个不进行任何处理的Function，即输出与输入值相等；
         */
        System.out.println(Function.identity().apply("a"));

    }

}
