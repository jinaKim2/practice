package com.example.practice.jinaBoard.boardservice;

import com.example.practice.jinaBoard.persistance.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BoardServiceMapper {
    List<HashMap> list();

    List<HashMap> list2();

    int insert(BoardVO boardVO);


    BoardVO findRefId(BoardVO boardVO);
}
