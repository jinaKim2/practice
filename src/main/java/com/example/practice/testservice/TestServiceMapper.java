package com.example.practice.testservice;

import com.example.practice.persistance.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface TestServiceMapper {

    UserVO findById(UserVO user);

    void insert(UserVO user);

    void update(UserVO user);

}
