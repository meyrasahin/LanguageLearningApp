package com.egeuniversity.LanguageLearning.Repository.Question;

import com.egeuniversity.LanguageLearning.Model.Question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
