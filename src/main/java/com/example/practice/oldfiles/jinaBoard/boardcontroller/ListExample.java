package com.example.practice.oldfiles.jinaBoard.boardcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListExample {
    public static void main() {
        List<String> list =new ArrayList<>();
        list.add("김진아");
        list.add("최유정");
        list.add("김대현");
        list.add("장영근");

        list.remove(0);








        String name1 = "김한상";
        String name2 = "이병수";

        Map<String, Object> map1 = new HashMap<>();
        map1.put("key", "value");
        map1.put("name1", name1);
        map1.put("name2", "김진아");
        map1.put("name3", "김대현");
        map1.put("length", 4);

        System.out.println(map1);
        System.out.println(map1.get("key"));
        System.out.println(map1.get("name2"));


        Map<String, Object> map2 = new HashMap<>();
        map2.put("key", "toilet");
        map2.put("name1", name2);
        map2.put("name2", "최유정");
        map2.put("name3", "최혜진");
        map2.put("length", 4);

        List<Map> mapList = new ArrayList<>();
        mapList.add(map1);
        mapList.add(map2);


        for(Map map : mapList){
            if(map.get("name4") != null){
                System.out.println(map.get("name4"));
            }

            if(1==1)
                System.out.println(map.get("name1"));
        }
    }
}
