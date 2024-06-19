package com.example.practice.dinner.Service;

import com.example.practice.dinner.persistance.RandomVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface RandomServiceMapper {
    void nameSave(RandomVo randomVo);

    RandomVo nameInsert(RandomVo randomVo);

    int update(RandomVo randomVo);

    List<HashMap> list();

    List<RandomVo> selectTRandom(RandomVo randomVo);


    // 이미 배정된 자리를 가져오는 메서드
    List<RandomVo> listAssignSeats();
}
