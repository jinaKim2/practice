package com.example.practice.oldfiles.jinaBoard.boardcontroller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapExample {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("khs", "김한상");
        dictionary.put("kja","김진아");

        System.out.println(dictionary.size() + "개의 단어가 있습니다.");

        Scanner scanner = new Scanner(System.in);

       /* String english = scanner.nextLine();
        String korean = dictionary.get(english);

        if (korean == null ) {
            System.out.println("사전에 존재하지 않는 단어입니다.");
        } else {
            System.out.println(english + "는" + korean + "입니다.");
        }*/

        /*Set<Map.Entry<String, String>> entries = dictionary.entrySet();

        for (Map.Entry<String, String> entry : entries ) {
            String english = entry.getKey();
            String korean = entry.getValue();

            System.out.println(english +": " + korean);
        }
        */
    }
}
