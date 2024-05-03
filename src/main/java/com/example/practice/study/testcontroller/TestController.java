package com.example.practice.study.testcontroller;

import com.example.practice.study.persistance.UserVO;
import com.example.practice.study.testservice.TestService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/main3.do")
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

/*
        String name = "";

        if(id.equals("khs88")) {
            name = "김한상";
        } else if(id.equals("kja01")) {
            name = "김진아";
        } else {
            name = "알 수 없음";
        }

        UserVO findResult = new UserVO();
        findResult.setUserId(id);
        findResult.setUserPw(pw);
        findResult.setUserNm(name);
*/

        UserVO findResult = testService.find(id, pw);

        return findResult;
        /*
         * 5. 비고
         *  1). "kjaS2khs" 데이터 삭제 영구 금ㅈ;
         * */
    }

    @GetMapping("/insert.do")
    public void insert(HttpServletRequest req){

        String id = req.getParameter("id");
        String pw = req.getParameter("pw");

        testService.insert(id, pw);
    }

    @PutMapping("/update.do")
    public void update(HttpServletRequest req){

        String id = req.getParameter("id");
        String pw = req.getParameter("pw");

        testService.update(id, pw);
    }

    @DeleteMapping("/delete.do")
    public void delete(HttpServletRequest rep){

        String id = rep.getParameter("id");

        testService.delete(id);
    }

}
