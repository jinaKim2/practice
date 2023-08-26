package com.example.practice.study.testdao;

import com.example.practice.study.persistance.UserVO;
import com.example.practice.study.testservice.TestServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {

    @Autowired
    TestServiceMapper testServiceMapper;

    public UserVO find(UserVO user) {

        UserVO result = testServiceMapper.findById(user);

        return result;
    }

    public void insert(UserVO user) {
        testServiceMapper.insert(user);
    }

    public void update(UserVO userVO) {
        testServiceMapper.update(userVO);
    }

    public void delete(String id) {
        testServiceMapper.delete(id);
    }
}
