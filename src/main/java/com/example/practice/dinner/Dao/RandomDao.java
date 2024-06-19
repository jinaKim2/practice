package com.example.practice.dinner.Dao;

import com.example.practice.dinner.Service.RandomServiceMapper;
import com.example.practice.dinner.persistance.RandomVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class RandomDao {
    @Autowired
    RandomServiceMapper randomServiceMapper;
    public void nameSave(RandomVo randomVo) {

        randomServiceMapper.nameSave(randomVo);
    }

    public RandomVo nameInsert(RandomVo randomVo) {
        RandomVo nameResult = randomServiceMapper.nameInsert(randomVo);
        return nameResult;
    }

    public int update(RandomVo randomVo) {
        return randomServiceMapper.update(randomVo);
    }

    public List<HashMap> list() {

        List<HashMap> result = randomServiceMapper.list();

        return result;
    }

    public List<RandomVo> selectTRandom(RandomVo randomVo) {

        List<RandomVo> result = randomServiceMapper.selectTRandom(randomVo);

        return result;
    }

    //이미 배정된 자리를 가져오는 메서드
    public List<RandomVo> listAssignedSeats() {
        return randomServiceMapper.listAssignSeats();
    }
}