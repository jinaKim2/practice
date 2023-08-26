package com.example.practice.jinaBoard.boardservice;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardServiceMapper {
    List<String> list();
}
