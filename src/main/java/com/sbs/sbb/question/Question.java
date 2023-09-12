package com.sbs.sbb.question;

import com.sbs.sbb.answer.Answer;
import com.sbs.sbb.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Entity // question 테이블
public class Question {

    @ManyToOne
    private SiteUser author;

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Integer id;

    @Column(length = 200) // VARCHAR(200)
    private String subject;

    @Column(columnDefinition = "TEXT") // TEXT
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
}

//mappedBy = "question" -> 얘네들이 답변을 저장하고 그 내용을 보여주는 역활을 한다.
// 얘네들 쓰기 전에는 답변도 저장이 안됐고, 0개의 답변이 있다고만 계속 보여줬다.
