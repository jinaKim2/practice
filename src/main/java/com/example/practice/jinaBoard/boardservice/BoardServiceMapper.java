package com.example.practice.jinaBoard.boardservice;

import com.example.practice.jinaBoard.persistance.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BoardServiceMapper {
    List<HashMap> list();

    int insert(BoardVO boardVO);
}
