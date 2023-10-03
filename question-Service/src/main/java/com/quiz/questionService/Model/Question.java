package com.quiz.questionService.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String questionTitle;

    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String difficultylevel;
    private String category;
    private String rightanswer;
}
