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
    /* git test */
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
        // 1. 첫번째 테이블 인서트
        boardService.insertTb1(boardVO);

       // 2. 첫번째 테이블인서트 된 키(id) 를 가져오기 위한 조회
       BoardVO selectKey = boardService.findRefId(boardVO);
       // 3. 두번째 테이블의 ref_id에 값을 넣어주기 위한 세팅
        boardVO.setRefId(selectKey.getId());

       // 두번째 insert시 result는 화면에 결과값 건네주기 위한 용도, 있어야 함
        int result = boardService.insertTb2(boardVO)

        return result;
    }

}
