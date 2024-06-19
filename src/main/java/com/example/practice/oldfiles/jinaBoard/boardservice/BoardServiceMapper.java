package com.example.practice.oldfiles.jinaBoard.boardservice;

import com.example.practice.oldfiles.jinaBoard.persistance.BoardVO;
import com.example.practice.oldfiles.jinaBoard.persistance.TestVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BoardServiceMapper {
    void insert2(BoardVO boardVO);

    void update2(BoardVO boardVO);

    void delete2(@Param("id") String id);

    List<HashMap> list();

    List<BoardVO> listBykhs();

    List<HashMap> list2();


    BoardVO findRefId(BoardVO boardVO);


    void post(BoardVO boardVO);

    /*BoardVO save(BoardVO boardVO);*/


    void saveTboard(BoardVO boardVO);

    Long findMaxId(BoardVO boardVO);

    void saveTest(TestVO testVO);



    List<Object> findById();
}
