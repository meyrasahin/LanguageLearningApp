package com.egeuniversity.LanguageLearning.Service.Exam;

import com.egeuniversity.LanguageLearning.Model.Exam.Exam;
import com.egeuniversity.LanguageLearning.Model.Exam.ExamDTO;
import com.egeuniversity.LanguageLearning.Service.Generic.BaseEntityService;

public interface ExamService extends BaseEntityService<Integer, Exam> {
    int calculateResult(ExamDTO examDTO);
}
