package com.example.practice.jinaBoard.boardservice;

import com.example.practice.jinaBoard.boaddao.BoardDao;
import com.example.practice.jinaBoard.persistance.BoardVO;
import com.example.practice.study.persistance.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardDao boardDao;

    public List<HashMap> list() {

        List<HashMap> result = boardDao.list();

        return result;
    }
    public int insert(BoardVO boardVO) {

        int result = boardDao.insert(boardVO);

        return result;
    }
}