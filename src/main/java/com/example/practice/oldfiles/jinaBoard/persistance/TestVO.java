package com.example.practice.oldfiles.jinaBoard.persistance;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TestVO {

    @Id
    public String id;
    public Long refId;

    public String title;

    public String content;
    public String regId;
}


