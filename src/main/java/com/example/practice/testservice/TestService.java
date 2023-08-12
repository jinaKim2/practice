package com.example.practice.testservice;

import com.example.practice.persistance.UserVO;
import com.example.practice.testdao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    TestDao testDao;

    public UserVO find(String id, String pw) {

        UserVO userVO = new UserVO();
        userVO.setUserId(id);
        userVO.setUserPw(pw);

        UserVO resultUserVO = testDao.find(userVO);

        return resultUserVO;
    }

    public void insert(String id, String pw) {

        UserVO userVO = new UserVO();
        userVO.setUserId(id);
        userVO.setUserPw(pw);

        testDao.insert(userVO);
    }

    public void update(String id,String pw){
        UserVO userVO = new UserVO();
        userVO.setUserId(id);
        userVO.setUserPw(pw);

        testDao.update(userVO);
    }


}