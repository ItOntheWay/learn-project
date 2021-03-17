package com.learn.jichu.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapDemo {
    public static void main(String[] args) {
//        System.out.println(Integer.compare(0,0));
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String item = iterator.next();
            System.out.println(item);
            if("2".equals(item)){
                iterator.remove();
            }
        }
        Iterator<String> iterator2 = list.iterator();
        while (iterator2.hasNext()){
            System.out.println("..."+iterator2.next());
        }
        for(String key : list){
            if(key.equals("2")){
                list.remove(key);
            }
        }
    }
}
