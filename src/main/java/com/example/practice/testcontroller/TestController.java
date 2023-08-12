package com.example.practice.testcontroller;

import com.example.practice.persistance.UserVO;
import com.example.practice.testdao.TestDao;
import com.example.practice.testservice.TestService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.constant.Constable;

@RestController
public class TestController {

    /*
    * 이걸 볼 때 쯤이면 진아님의 뇌는 이미 인터스텔라 영화한편 찍고 초기화 되었을 것으로 짐작하기에
    * 주석을 많이, 자세히 달아놨음
    * */

    /**
     * 컨트롤러가 어떤 @Service에 연결해야할 지 인식시켜 줌
     * */
    @Autowired
    TestService testService;


    /**
     * 1. HttpServletRequest req : GET/POST 요청 파라미터 수신
     *  1). localhost:8080/find?id=kjaS2khs
     *   - localhost:8080 서버의 "/find" 요청을 받겠다고 명시(@RequestMapping)한 메소드에 파라미터 id=kjaS2khs 를 추가해 호출
     *
     *  2). localhost:8080/find?id=kjaS2khs&pw=password486
     *   - 파라미터 2개 요청
     */
    @RequestMapping("/find")
    public UserVO find(HttpServletRequest req){
        /**
         * 2. String id = req.getParameter("id");
         *  1). req에서 "id"라는 파라미터의 값을 가져와 String id에 넣어 줌
         *   - String id = "kjaS2khs";
         */
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");

        /**
         * 3. UserVO findResult = testService.find(id, pw);
         *  1). testService.find(id, pw);
         *   - testService의 find 메소드에 id와 pw를 담아 일을 시키고, 실행결과를 받아 옴
         *  2). UserVO findResult = testService.find(id, pw);
         *   - 1). 의 실행 결과를 UserVO 형태의 findResult 라는 이름을 가진 변수에 넣어 줌
         *   - ex) 백인 "챨스"가 있고, 흑인 "챨스"가 있는데, 그냥 "챨스" 라고만 하면 백인을 부르는건지, 흑인을 부르는건지 알 수 없어 뇌정지 발생
         *   - 따라서 백인 "챨스" / 흑인 "챨스" 등 챨스가 누굴 말하는건지 앞에 명시해줘야 함
         *   - UserVO findResult 에서 UserVO 로 명시해 준 이유는
         *     testService.find(id, pw); 의 결과를 동일한 형태로 받아야하기 때문
         *     (String findResult 로 받을경우 오류 발생, 난 UserVO로 돌려주는데 넌 왜 String으로 받냐!! 못주겠다!!)
         */
        UserVO findResult = testService.find(id, pw);

        /**
         * 4. return findResult;
         *  1). 조회결과 반환
         *   - 정상 조회시 까만화면에 데이터 보일 것
         *   - 비정상 조회시 그냥 하얀 화면
         *   - 비정상 조회면 왜 비정상 조회인지 DB까지 데이터 / 쿼리 확인
         *   - kjaS2khs : 정상
         *   - kjaS2khs2 : 비정상 << 왜 비정상인지 테스트해보긔
         */
        return findResult;

        /*
         * 5. 비고
         *  1). "kjaS2khs" 데이터 삭제 영구 금ㅈ;
         * */
    }

    @RequestMapping("/insert")
    public void insert(HttpServletRequest req){

        String id = req.getParameter("id");
        String pw = req.getParameter("pw");

        testService.insert(id, pw);
    }

    @RequestMapping("/update")
    public void update(HttpServletRequest req){

        String id = req.getParameter("id");
        String pw = req.getParameter("pw");

        testService.update(id, pw);
    }

}
