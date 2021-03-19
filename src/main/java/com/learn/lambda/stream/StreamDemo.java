package com.learn.lambda.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author jpb
 * @version 1.0
 * @date 2021/3/19 11:08
 * <p>
 * java8 stream 操作
 */
public class StreamDemo {
    public static void main(String[] args) {

        //map 方法用于映射每个元素到对应的结果，以下代码片段使用 map 输出了元素对应的平方数：
        /*List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.println(squaresList);*/

        //Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors 可用于返回列表或字符串
        /*List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选列表: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);
        //假设我们要将一个String类型的Stream对象中的每个元素添加相同的后缀.txt，如a变成a.txt
        Stream<String> s = Stream.of("test", "t1", "t2", "teeeee", "aaaa");
        s.map(n -> n.concat(".txt")).forEach(System.out::println);
        */

        //統計 一些产生统计结果的收集器也非常有用。它们主要用于int、double、long等基本类型上，它们可以用来产生类似如下的统计结果。
        /*List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());*/

        //filter用于对Stream中的元素进行过滤，返回一个过滤后的Stream
        /*Stream<String> s = Stream.of("test", "t1", "t2", "teeeee", "aaaa");
        //查找所有包含t的元素并进行打印
        s.filter(n -> n.contains("t")).forEach(System.out::println);*/

        //flatMap 元素一对多转换：对原Stream中的所有元素使用传入的Function进行处理，每个元素经过处理后生成一个多个元素的Stream对象，
        // 然后将返回的所有Stream对象中的所有元素组合成一个统一的Stream并返回；
        //假设要对一个String类型的Stream进行处理，将每一个元素的拆分成单个字母，并打印：
       /* Stream<String> s = Stream.of("test", "t1", "t2", "teeeee", "aaaa");
        Predicate<String> p = m -> m.contains("t");
//        s.flatMap(n -> Stream.of(n.split(""))).forEach(System.out::println);
        s.filter(o->p.test(o)).flatMap(n->Stream.of(n.split(""))).forEach(System.out::println);*/

       //takeWhile 如果Stream是有序的（Ordered），那么返回最长命中序列（符合传入的Predicate的最长命中序列）组成的Stream；如果是无序的，那么返回的是所有符合传入的Predicate的元素序列组成的Stream。
        //与Filter有点类似，不同的地方就在当Stream是有序时，返回的只是最长命中序列。
        //如以下示例，通过takeWhile查找”test”, “t1”, “t2”, “teeeee”, “aaaa”, “taaa”这几个元素中包含t的最长命中序列：
        /*Stream<String> s = Stream.of("test", "t1", "t2", "teeeee", "aaaa", "taaa");
        //以下结果将打印： "test", "t1", "t2", "teeeee"，最后的那个taaa不会进行打印
        s.takeWhile(n -> n.contains("t")).forEach(System.out::println); //jdk9以上版本方法*/

        //dropWhile 与takeWhile相反，如果是有序的，返回除最长命中序列外的所有元素组成的Stream；如果是无序的，返回所有未命中的元素组成的Stream;
        //
        //如以下示例，通过dropWhile删除”test”, “t1”, “t2”, “teeeee”, “aaaa”, “taaa”这几个元素中包含t的最长命中序列：
        /*Stream<String> s = Stream.of("test", "t1", "t2", "teeeee", "aaaa", "taaa");
        //以下结果将打印："aaaa", "taaa" 　
        s.dropWhile(n -> n.contains("t")).forEach(System.out::println);*/

       /**
        * https://blog.csdn.net/icarusliu/article/details/79504602
        * reduce 以及collect 方法
        * */
        Stream s = Stream.of(1,2,3,4,5,6,7,8,9);
//        s.forEach(o-> System.out.println(o));
        // peek:使用传入的Consumer对象对所有元素进行消费后，返回一个新的包含所有原来元素的Stream对象
        //map:元素一对一转换：使用传入的Function对象对Stream中的所有元素进行处理，返回的Stream对象中的元素为原元素处理后的结果
        s.peek(x -> System.out.println("a"+x)).limit(2).forEach(o->System.out.println(o));
//        s.peek(x->System.out.println("A"+x)).limit(3).map(n -> (int)n>0?n:0).forEach(o -> System.out.println(o));
//        s.limit(3).map(o-> o+"...").forEach(o-> System.out.println(o));
//        s.peek(x->System.out.println("A"+x)).peek(m -> System.out.println("b"+m)).limit(3).forEach(o-> System.out.println(o));

       /* Iterator<String> sourceIterator = Arrays.asList("A", "B", "C").iterator();
        Stream<String> targetStream = Stream.generate(sourceIterator::next);
        targetStream.forEach(System.out::println);*/
        //generator方法，返回一个无限长度的Stream
        /*Iterator<String> sourceIterator = Arrays.asList("A", "B", "C").iterator();
        Iterable<String> iterable = () -> sourceIterator;
        Stream<String> targetStream = StreamSupport.stream(iterable.spliterator(), false);
        targetStream.forEach(System.out::println);*/
        //Reduce Reduce中文含义为：减少、缩小；而Stream中的Reduce方法干的正是这样的活：根据一定的规则将Stream中的元素进行计算后返回一个唯一的值。
        //它有三个变种，输入参数分别是一个参数、二个参数以及三个参数；
        //stream 求和
        /*Stream<Integer> s = Stream.of(1, 2, 3, 4, 5, 6);
        Optional<Integer> sum = s.reduce((o1, o2)->{return o1+o2;} ); //一个参数
        System.out.println(sum.get());*/
        //两个参数 例如：stream中所有元素拼接再在前面添加value
        /*Stream<String> s = Stream.of("test", "t1", "t2", "teeeee", "aaaa", "taaa");
        String res = s.reduce("value",(a,b)-> a.concat(b));
        System.out.println(res);*/
        /*List<Integer> array = Arrays.asList(3, 5, 3, 2);
        Optional<Integer> he = array.stream().reduce((o1,o2)->{return o1+o2;});
        System.out.println("list的.."+he.get());*/
        //三个参数 非并行，第三个参数不生效，例：
        /*Stream<String> s1 = Stream.of("aa", "ab", "c", "ad");
        ArrayList<String> list = s1.reduce(new ArrayList<String>(),(r,t) -> { r.add(t); return  r; },(m,n) -> m );
        System.out.println(list);*/

        //也可以进行元素过滤，即模拟Stream中的Filter函数查找其中含有字母a的所有元素，打印结果将是aa ab ad
        /*Stream<String> s1 = Stream.of("aa", "ab", "c", "ad");
        Predicate<String> predicate = t -> t.contains("a");
        ArrayList<String> list1 = s1.reduce(new ArrayList<String>(),(r,t)->{ if (predicate.test(t)) r.add(t);return r; },(m,n)-> m);
        System.out.println(list1);*/
        //当Stream是并行时，第三个参数就有意义了，它会将不同线程计算的结果调用combiner做汇总后返回。
        //注意由于采用了并行计算，前两个参数与非并行时也有了差异！
        //举个简单点的例子，计算4+1+2+3的结果，其中4是初始值：
        //例:非并行下 第一个参数4作为初始值，执行第二个参数的表达式即 4+1=5，5+2=7,7+3=10；
        /*Integer tes = Stream.of(1, 2, 3).reduce(4, (s1, s2) -> s1 + s2, (s1, s2) -> s1 + s2);
        System.out.println(tes);*/
        /*Stream<Integer> s2 = Stream.of(1, 2, 3);
        Integer result = s2.reduce(4,(r,t)->{ return r+t;},(m,n)->{return (m+n) ;}); //非并行*/
//并行，类似多线程 第一个参数4相当于线程内存值（拷贝内存数据）
//因此计算过程现在是这样的：线程1：1 + 4 = 5；线程2：2 + 4 = 6；线程3：3 + 4 = 7；Combiner函数： 5 + 6 + 7 = 18！
        /*Stream<Integer> s2 = Stream.of(1, 2, 3);
        Integer result = s2.parallel().reduce(4,(r,t)->{ return r+t;},(m,n)->{return (m+n) ;});
        System.out.println(result);*/
//        System.out.println(Stream.of(1, 2, 3).map(n -> n + 4).reduce((s1, s2) -> s1 * s2));
//        Stream<String> s1 = Stream.of("aa", "ab", "c", "ad");
//模拟Filter查找其中含有字母a的所有元素，由于使用了r1.addAll(r2)，其打印结果将不会是预期的aa ab ad
        //当Stream是并行时，第三个参数就有意义了，它会将不同线程计算的结果调用combiner做汇总后返回。
        /*Stream<String> s1 = Stream.of("aa", "ab", "c", "ad");
        Predicate<String> predicate = t -> t.contains("a");
        s1.parallel().reduce(new ArrayList<String>(), (r, t) -> {if (predicate.test(t)) r.add(t);  return r; },
                (r1, r2) -> { r1.addAll(r2); return r1; }).stream().forEach(System.out::println);*/
    }
}
