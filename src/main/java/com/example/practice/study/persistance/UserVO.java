package com.example.practice.study.persistance;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO {
    public String id;
    public String userId;
    public String userNm;
    public String userPw;
    public String lastLoginDt;
}
