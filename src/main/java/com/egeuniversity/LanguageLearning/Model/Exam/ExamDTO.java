package com.egeuniversity.LanguageLearning.Model.Exam;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExamDTO {
    private String traineeAnswers;
    private int traineeId;
    private int courseId;
}
