package com.example.practice.oldfiles.jinaBoard.boardcontroller; // 자바 클래스들을 그룹화하는 방법

import com.example.practice.oldfiles.jinaBoard.boardservice.BoardService; // 'boardservice' 패키지에 있는 'BoardService' 클래스를 현재 파일에서 사용하겠다는 것을 선언
import com.example.practice.oldfiles.jinaBoard.persistance.TestVO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired; // Spring Framework에서 @Autowired 어노테이션을 사용하기 위해 필요한 패키지를 import 한다
import org.springframework.web.bind.annotation.*; // Spring Framework
import org.springframework.web.servlet.ModelAndView; // Spring Framework

import java.util.HashMap; //java.util 패키지에서 HashMap 클래스를 현재 파일에서 사용하겠다는 것을 선언한다.
import java.util.List; // java.util 패키지에서 List 인터페이스를 현재 파일에서 사용하겠다는 것을 선언한다.


@RestController
@RequestMapping("")
public class BoardController { // BoardController라는 클래스를 선언

    @Autowired // BoardService 타입의 객체를 자동으로 주입 받는다. 이는 BoardController 가 BoardService 의 메서드들을 사용할 수 있도록 함
    BoardService boardService;

    /* git test */
    @GetMapping("/main.do") // HTTP GET 요청 중 main.do 경로로 요청되는 것을 처리하는 메서드를 지정
    public ModelAndView main() {

        List<HashMap> result = boardService.list(); // boardService 의 list 메서드를 호출하여, 결과를 List<HashMap> 타입의 result 변수에 저장한다.

        ModelAndView modelAndView = new ModelAndView(); // main 메서드를 선언하며, 이 메서드는 ModelAndView 객체를 반환한다.ModelAndView 객체를 생성하고, 이를 modelAndView 변수에 할당한다.
        modelAndView.addObject("msg", result); // modelAndView 객체에 msg 라는 이름으로 result 리스트를 추가한다.
        modelAndView.setViewName("page/main/index3"); // modelAndView 객체의 뷰 이름을 page/main/index3으로 설정한다. 이는 클라이언트에게 보여질 뷰 페이지를 지정한다.
        return modelAndView; // 설정된 modelAndView 객체를 반환한다.

    }

    @GetMapping("/main2.do")
    public ModelAndView main2() {
        List<HashMap> result = boardService.list2();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", result);
        modelAndView.setViewName("page/main/index3");
        return modelAndView;
    }
    /*@GetMapping("/test.do")
    public ModelAndView test() {
        List<String> result = boardService.list3();

        ModelAndView modelAndView =new ModelAndView();
        modelAndView.
    } */

    @GetMapping("/moveRegPage.do") // moveRegPage.do  경로의 GET 요청을 처리하는 메서드를 지정
    public ModelAndView moveRegPage() {
        ModelAndView modelAndView = new ModelAndView(); // moveRegPage 메서드를 선언하며, modelAndView 의 객체를 반환한다. ModelAndView 객체를 생성하고, 이를 modelAndView 변수에 할당한다.

        modelAndView.setViewName("page/main/moveRegPage"); // modelAndView 객체의 뷰 이름을 page/main/moveRegPage 로 설정한다.
        return modelAndView; // 설정된 modelAndView 객체를 반환한다.
    }

    @GetMapping("/insert2.do")
    public void insert2(HttpServletRequest req) {

        String title = req.getParameter("title");
        String regId = req.getParameter("regId");

        boardService.insert2(title, regId);


    }

    @GetMapping("/list2.do")
    public static ModelAndView list(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/main/boardList");
        return modelAndView;






    }


  /*  @GetMapping("/listTest.do")
    public static void list(String[] args) {
        System.out.println("좋아하는 음식의 이름을 입력하세요.");
        ArrayList<String> Food = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);

        While (true) {
            String myFood =scanner.nextLine();

            if (myFood.equals("0")) {
                break;

                if(food.contains(myFood)) {
                    System.out.println(myFood + "은 이미 목록에 있습니다."){
                        else{

                        }
                    }
                }
            }
        }

    }*/


    @GetMapping("/update2.do")
    public String update(HttpServletRequest req){

        String id = req.getParameter("id");
        String title = req.getParameter("title");
        String modId = req.getParameter("modId");

        boardService.update2(id, title, modId);
        return title;
    }

    @GetMapping("/delete2.do")
    public String delete(HttpServletRequest req){

        String id = req.getParameter("id");

        boardService.delete2(id);
        return id;
    }

    /*@GetMapping("/delete2.do")
    public String delete(HttpServletRequest req) {

        String id = req.getParameter("id");
        String delYn = req.getParameter("delYn");

        boardService.delete2(id,delYn);

        return delYn;
    }*/

    @GetMapping("/moveRegPage2.do")
    public ModelAndView moveRegPage2() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("page/main/moveRegPage2");
        return modelAndView;
    }
    @PostMapping("/postPage.do")
    public void save (@RequestBody TestVO testVo) {

        boardService.save(testVo);

    }




    @GetMapping("board/view")
    public ModelAndView boardView() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/main/boardView");
        return modelAndView;
    }



/*
    @GetMapping("/upeate/{id")
    public String updateForm(@PathVariable long id, Model model) {
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("boardUpdate",boardDTO);
        return "update";
    }
    */
}
