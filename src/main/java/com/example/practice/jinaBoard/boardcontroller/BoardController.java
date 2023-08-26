package com.example.practice.jinaBoard.boardcontroller;

import com.example.practice.jinaBoard.boardservice.BoardService;
import com.example.practice.jinaBoard.persistance.BoardVO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/main.do")
    public ModelAndView main(){
        ModelAndView modelAndView = new ModelAndView();

        List<HashMap> result = boardService.list();

        modelAndView.addObject("msg", result);
        modelAndView.setViewName("page/main/index3");
        return modelAndView;
    }
    @GetMapping("/moveRegPage.do")
    public ModelAndView moveRegPage(){
        ModelAndView modelAndView = new ModelAndView();

         modelAndView.setViewName("page/main/moveRegPage");
        return modelAndView;
    }
    @PostMapping("/registBoard.do")
    public int insert(@RequestBody BoardVO boardVO){

        int result = boardService.insert(boardVO);

        return result;
    }

}
