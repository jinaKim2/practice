package com.example.practice.study.testservice;

import com.example.practice.study.persistance.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardServiceMapper {
    UserVO list();
}
