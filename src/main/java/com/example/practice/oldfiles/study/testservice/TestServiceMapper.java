package com.example.practice.oldfiles.study.testservice;

import com.example.practice.oldfiles.study.persistance.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TestServiceMapper {

    UserVO findById(UserVO user);

    UserVO loginUser(UserVO user);

    void insert(UserVO user);

    void update(UserVO user);

    void delete(@Param("userId") String id);
}
