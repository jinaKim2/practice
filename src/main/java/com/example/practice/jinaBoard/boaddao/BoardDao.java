package com.example.practice.jinaBoard.boaddao;

import com.example.practice.jinaBoard.boardservice.BoardServiceMapper;
import com.example.practice.study.persistance.UserVO;
import com.example.practice.study.testservice.TestServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDao {
    @Autowired
    BoardServiceMapper boardServiceMapper;
    public List<String> list() {

        List<String> result = boardServiceMapper.list();

        return result;
    }

}
