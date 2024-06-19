package com.example.practice.oldfiles.jinaBoard.persistance;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class BoardVO {
    @Id
    public String id;
    public String refId;

    public String title;
    public String content;
    public int visitCnt;
    public String regId;
    public String regDt;
    public String modId;
    public LocalDateTime modDt;
    public String delYn;

    public void setId(Long id) {
        this.id = String.valueOf(id);
    }

    public String getId() {
        return id;
    }

    public void addAttribute(String msg, BoardVO boardView) {
    }
}

