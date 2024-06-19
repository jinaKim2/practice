package com.example.practice.oldfiles.study.testdao;

import com.example.practice.oldfiles.study.testservice.TestServiceMapper;
import com.example.practice.oldfiles.study.persistance.UserVO;
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

    public UserVO loginUser(UserVO userVO) {
        UserVO result = testServiceMapper.loginUser(userVO);

        return  result;
    }
}
