package com.learn.jichu.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 * @author  jingpb
 * @date 20200714
 * */
public class ArrayListDemo {

    /**
     * ArrayList扩容
     * */
    public static void main(String[] args) {
        /*List list = new ArrayList<>();
        System.out.println("list size:"+list.size());
        list.add("a");
        list.add("B");*/
        /*int[] a = new int[10];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;
        a[4] = 4;
        a[5] = 5;
        a[6] = 6;
        a[7] = 7;
        a[8] = 8;
        a[9] = 9;

        //arraycopy()方法实现数组自己复制自己
        //elementData:源数组;index:源数组中的起始位置;elementData：目标数组；index + 1：目标数组中的起始位置； size - index：要复制的数组元素的数量；
        //System.arraycopy(elementData, index, elementData, index + 1, size - index);
        System.arraycopy(a, 2, a, 3, 1);
        a[2]=99;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }*/

        int[] a1 = new int[3];
        a1[0] = 0;
        a1[1] = 1;
        a1[2] = 2;
        System.out.println("a1.length"+a1.length);
        int[] b = Arrays.copyOf(a1, 10);
        System.out.println("b.length"+b.length);
        for(int i=0 ;i <b.length;i++){
            System.out.println(b[i]);
        }
        //Arrays.asList()的坑
        List list = Arrays.asList(a1);
        System.out.println("----"+list.get(0).toString());
        System.out.println(list.get(1));

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        // 第二种方式(容易理解)
        Integer[] integer1 = new Integer[arrayList.size()];
        arrayList.toArray(integer1);
        LinkedList linkedList = new LinkedList();
//        linkedList.addAll(1,arrayList);
        linkedList.addFirst(0); // 添加元素到列表开头
        linkedList.add(1); // 在列表结尾添加元素
        linkedList.add(2, 2); // 在指定位置添加元素
        linkedList.addLast(3); // 添加元素到列表结尾
//        linkedList.indexOf(1);
//        System.out.println(linkedList.indexOf(null));

        /************************** Queue操作 ************************/
        System.out.println("-----------------------------------------");
        System.out.println("peek(): " + linkedList.peek()); // 获取但不移除此列表的头
        System.out.println("element(): " + linkedList.element()); // 获取但不移除此列表的头
        linkedList.poll(); // 获取并移除此列表的头
        System.out.println("After poll():" + linkedList);
        linkedList.remove();
        System.out.println("After remove():" + linkedList); // 获取并移除此列表的头
        linkedList.offer(4);
        System.out.println("After offer(4):" + linkedList); // 将指定元素添加到此列表的末尾
    }

}
