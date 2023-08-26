package com.example.practice.jinaBoard.boardcontroller;

import com.example.practice.jinaBoard.boardservice.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/main.do")
    public ModelAndView main(){
        ModelAndView modelAndView = new ModelAndView();

        List<String> result = boardService.list();

        modelAndView.addObject("msg", result);
        modelAndView.setViewName("page/main/index3");
        return modelAndView;
    }
}
