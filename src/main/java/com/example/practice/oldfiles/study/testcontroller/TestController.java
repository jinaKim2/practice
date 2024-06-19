package com.example.practice.oldfiles.study.testcontroller;

import com.example.practice.oldfiles.study.persistance.UserVO;
import com.example.practice.oldfiles.study.testservice.TestService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/login.do")
    public ModelAndView main(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "서버에서 받아온 값 입니다.");
        // modelAndView.setViewName("page/main/index");
        modelAndView.setViewName("page/main/index2");
        return modelAndView;
    }
    /*------------------Ajax 부분입니둥 -------------------*/
    @GetMapping("/AjaxMain.do")
    public ModelAndView AjaxMain(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "서버에서 받아온 값 입니다.");
        modelAndView.setViewName("page/main/AjaxMain");
        return modelAndView;
    }

    @GetMapping("/AjaxSignUp.do")
    public ModelAndView AjaxSignUp(){
        ModelAndView modelAndView = new ModelAndView();
        /*modelAndView.addObject("msg", "서버에서 받아온 값 입니다.");*/
        modelAndView.setViewName("page/main/AjaxSignUp");
        return modelAndView;

    }
    @PostMapping("/AjaxLogin.do")
    public UserVO loginResponse(@RequestBody UserVO userVo){

        String id = userVo.getUserId();
        String pw = userVo.getUserPw();
        UserVO loginResult = testService.loginUser(id, pw);

        // 조회한 결과가 널이 아니면 네이트판으로 이동 => 성공이란 이야기쥬??
        /*
         * ㅅ숙제
         * 로그인 성공 시 네이트판으로 바로 이동
         * 로그인 실패 시 기존 화면으로 이동해서 로그인 실패 안내문구 출력
         * */
        if(loginResult != null)

        return loginResult;
        return loginResult;
    }

    /*-----------------^^-Ajax 부분입니둥 ---^^----------------*/
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
