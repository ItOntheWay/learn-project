package com.learn.jichu;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Arrays.asList();的坑
 * */

public class ArrayToListDemo {
    public static void main(String[] args) {
        Integer[] myArray = { 1, 2, 3 };
       /* List myList = Arrays.asList(1, 2, 3);
        myList.add(4); //java.lang.UnsupportedOperationException*/
        /*List list = Arrays.asList(myArray);
        list.add(4);//java.lang.UnsupportedOperationException*/
       //方法1:
        /*List myList = new ArrayList(Arrays.asList(1,2,3));
        myList.add(4);*/
        //方法2:
        /*List list = Arrays.asList(1,2,3).stream().collect(Collectors.toList());
        list.add(4);*/
        //Collection.toArray()方法使用的坑&如何反转数组
        /*String [] s= new String[]{ "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };
        List<String> list = Arrays.asList(s);
        Collections.reverse(list);
        s=list.toArray(new String[0]);//没有指定类型的话会报错*/
        List<String> listDemo = Lists.newArrayList();
        listDemo.add("1");
        listDemo.add("2");
        //不要在 foreach 循环里进行元素的 remove/add 操作
        /*for (String s: listDemo) {
            if(s.equals("2")){
                listDemo.remove(s); //java.util.ConcurrentModificationException
            }
        }*/
        //推荐使用迭代器
        Iterator<String> iterable = listDemo.iterator();
        while (iterable.hasNext()){
           String item = iterable.next();
           if("2".equals(item)){
               iterable.remove();
           }
        }
        System.out.println(listDemo);
    }
}
