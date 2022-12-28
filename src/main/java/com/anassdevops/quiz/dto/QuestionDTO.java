package com.anassdevops.quiz.dto;

import com.anassdevops.quiz.entity.CorrectAnswer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor @AllArgsConstructor
public class QuestionDTO {

    private String description;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private CorrectAnswer correctAnswer;

    private  String quizId;
}
