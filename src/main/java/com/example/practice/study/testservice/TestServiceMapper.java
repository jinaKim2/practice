package com.example.practice.study.testservice;

import com.example.practice.study.persistance.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TestServiceMapper {

    UserVO findById(UserVO user);

    void insert(UserVO user);

    void update(UserVO user);

    void delete(@Param("userId") String id);
}
