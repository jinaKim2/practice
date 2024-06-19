package com.example.practice.oldfiles.jinaBoard.boardcontroller;

import com.example.practice.oldfiles.jinaBoard.boardservice.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("")
public class postController {
    @Autowired
    PostService postService;

  /* @GetMapping("/posts.do")
   public BoardVO posts(@RequestBody BoardVO boardVO){
       String title = boardVO.getTitle();
       String content = boardVO.getContent();

       BoardVO postResult = postService.Post(title, content);

       return postResult;
   }*/

    // 게시물 내용 저장
    @PostMapping("posts.do")
    public ModelAndView createPost(@RequestParam("title") String title, @RequestParam("content") String content) {
        //DB에 데이터를 저장하는 로직
        postService.Post(title, content);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/main2.do");
        return modelAndView;
    }

    //상세페이지
    @GetMapping("/boardView.do")
    public ModelAndView boardView(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "서버에서 받아온 값 입니다.");
        modelAndView.setViewName("page/main/boardView");
        return modelAndView;
    }

    }

