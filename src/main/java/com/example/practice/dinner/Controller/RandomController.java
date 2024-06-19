package com.example.practice.dinner.Controller;

import com.example.practice.dinner.Service.RandomService;
import com.example.practice.dinner.persistance.RandomVo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("")
public class RandomController {

    @Autowired
    RandomService randomService;


    @GetMapping("/startView.do")
    public ModelAndView start() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/main/dinner/StartView");
        return modelAndView;
    }


    @GetMapping("/mainView.do")
    public ModelAndView main() {

        /* List<HashMap> result = randomService.list();*/

        ModelAndView modelAndView = new ModelAndView();
        /* modelAndView.addObject("randomMsg",result);*/
        modelAndView.setViewName("page/main/dinner/mainView");
        return modelAndView;
    }

    // 등록
    @GetMapping("/userNameInsert.do")
    public void nameInsert(HttpServletRequest req) {

        String userName = req.getParameter("userName");

        randomService.nameSave(userName);
    }

    // 이름 DB에 있는지 확인
   /* @PostMapping("nameSelect.do")
    public RandomVo nameResponse(@RequestBody RandomVo randomVo){

        String userName = randomVo.getUserName();
        RandomVo nameResult = randomService.nameSelect(userName);

        if(nameResult != null)사

            return nameResult;
        return nameResult;
    }*/


    // nameInsert.do 경로로 Post 요청을 처리하는 메서드
    @PostMapping("/nameInsert.do")
    public RandomVo nameResponse(@RequestBody RandomVo randomVo) {
        // 사용자의 이름을 가져온다.
        String userName = randomVo.getUserName();
        //서비스를 호출하여 DB에서 사용자 이름에 해당하는 정보를 찾는다.
        RandomVo nameResult = randomService.nameInsert(userName);
        //만약 결과가 null이면 (사용자 정보가 디비에 없으면)
        if (nameResult == null) {
            RandomVo errorResult = new RandomVo();
            errorResult.setErrMsg("Tech실 소속 사용자가 아닙니다. 이름을 다시 입력해주세요.");
            return errorResult;
        }
        return nameResult;
    }
            // 찾을 수 없음 상태를 반환
          /*  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        // 사용자 정보가 디비에 있으면 그 정보를 정상적으로 반환
        return ResponseEntity.ok(nameResult);
    }*/


    @PostMapping("/selectView.do")
    // 'select' 메서드 선언
    public List<RandomVo> select(@RequestBody RandomVo randomVo) {
        //RandomService 객체의 select 메서드를 호출하여 조회 결과를 반환한다.
        return randomService.select(randomVo);

    }
}


