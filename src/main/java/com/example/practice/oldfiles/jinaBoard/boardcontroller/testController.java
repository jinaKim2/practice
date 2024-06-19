package com.example.practice.oldfiles.jinaBoard.boardcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

public class testController {
    @GetMapping("/listTest.do")
    public ModelAndView list() {
    List<String> listA =new ArrayList<String>();
    List<String> listB = new LinkedList<String>();
    List<String> listC = new Vector<String>();
    List<String> listD = new Stack<String>();

        return list(listA,listB,listC,listD);

    }

    private ModelAndView list(List<String> listA, List<String> listB, List<String> listC, List<String> listD) {
        return null;
    }


}