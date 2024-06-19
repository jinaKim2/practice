package com.example.practice.oldfiles.jinaBoard.boardservice;

import com.example.practice.oldfiles.jinaBoard.boaddao.BoardDao;
import com.example.practice.oldfiles.jinaBoard.persistance.TestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class PostService {
    @Autowired
    BoardDao boardDao;

    /*public BoardVO Post(String title, String content) {

        BoardVO boardVO = new BoardVO();
        boardVO.setTitle(title);
        boardVO.setContent(content);

        BoardVO resultBoardVO = boardDao.save(boardVO);

        return resultBoardVO;
    }*/


    public void Post( String title, String content){
        TestVO testVo = new TestVO();

        testVo.setTitle(title);
        testVo.setContent(content);


        //boardDao.save(testVo);
    }

    public Model boardView(Integer id){
        return (Model) boardDao.findById(id).get(id);
    }
}
