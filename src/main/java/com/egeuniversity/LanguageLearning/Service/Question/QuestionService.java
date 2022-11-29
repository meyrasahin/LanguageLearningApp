package com.egeuniversity.LanguageLearning.Service.Question;

import com.egeuniversity.LanguageLearning.Model.Question.Question;
import com.egeuniversity.LanguageLearning.Service.Generic.BaseEntityService;

import java.util.List;

public interface QuestionService extends BaseEntityService<Integer, Question> {
    List<Question> listQuestions();
}
