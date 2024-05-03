package com.example.practice.jinaBoard.boaddao;

import com.example.practice.jinaBoard.boardservice.BoardServiceMapper;
import com.example.practice.jinaBoard.persistance.BoardVO;
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
    public List<HashMap> list2() {

        List<HashMap> result = boardServiceMapper.list2();

        return result;
    }

    public int insert(BoardVO boardVO) {
        int result = boardServiceMapper.insert(boardVO);
        BoardVO selectKey = boardServiceMapper.findRefId(boardVO);

        return result;
    }

}
