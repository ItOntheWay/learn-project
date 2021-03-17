package com.learn.jichu.collection;

import java.util.*;

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
        Map map = new HashMap<>();
        map.put("a","1");
        map.put("b","2");
        map.put("c","3");
        Iterator<Map.Entry> iterator1 = map.entrySet().iterator();
        while(iterator1.hasNext()){
            Map.Entry entry = iterator1.next();
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            System.out.println("key ="+key +",value = "+value);
        }

    }
}
