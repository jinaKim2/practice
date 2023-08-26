package com.example.practice.jinaBoard.boardcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("")
public class BoardController {

    @Autowired
    TestService testService;

    @GetMapping("/main.do")
    public ModelAndView main(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "서버에서 받아온 값 입니다.");
        // modelAndView.setViewName("page/main/index");
        modelAndView.setViewName("page/main/index2");
        return modelAndView;
    }

    @PostMapping("/find.do")
    public UserVO find(@RequestBody UserVO userVo){

        String id = userVo.getUserId();
        String pw = userVo.getUserPw();

        UserVO findResult = testService.find(id, pw);

        return findResult;
        /*
         * 5. 비고
         *  1). "kjaS2khs" 데이터 삭제 영구 금ㅈ;
         * */
    }
}
