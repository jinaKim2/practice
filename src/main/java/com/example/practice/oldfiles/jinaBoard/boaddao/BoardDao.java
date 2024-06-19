package com.example.practice.oldfiles.jinaBoard.boaddao;

import com.example.practice.oldfiles.jinaBoard.boardservice.BoardServiceMapper;
import com.example.practice.oldfiles.jinaBoard.persistance.BoardVO;
import com.example.practice.oldfiles.jinaBoard.persistance.TestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class BoardDao {
    @Autowired
    BoardServiceMapper boardServiceMapper;



    public List<HashMap> list() {

        List<HashMap> result = boardServiceMapper.list();

        return result;
    }

    public List<BoardVO> list(String delYn) {

        List<BoardVO> result = boardServiceMapper.listBykhs();

        return result;
    }

    public List<HashMap> list2() {

        List<HashMap> result = boardServiceMapper.list2();

        return result;
    }

    public void insert2(BoardVO boardVO) {
        boardServiceMapper.insert2(boardVO);
    }

    public void update2(BoardVO boardVO) {
        boardServiceMapper.update2(boardVO);
    }


    public void delete2(String id) {
        boardServiceMapper.delete2(id);
    }



    /*public BoardVO save(BoardVO boardVO){
        BoardVO result = boardServiceMapper.save((boardVO));

        return result;
    }*/

    public  void saveTboard(BoardVO boardVO) {
        boardServiceMapper.saveTboard(boardVO);
    }

    public Long findMaxId(BoardVO boardVO) {
        Long id = boardServiceMapper.findMaxId(boardVO);
        return id;
    }

    public void saveTest(TestVO testVO) {
        boardServiceMapper.saveTest(testVO);
    }





    public List<Object> findById(Integer id) {
        List<Object> result = boardServiceMapper.findById();

        return result;
    }
}

