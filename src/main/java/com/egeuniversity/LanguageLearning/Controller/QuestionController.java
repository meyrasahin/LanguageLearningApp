package com.egeuniversity.LanguageLearning.Controller;

import com.egeuniversity.LanguageLearning.Model.Question.Question;
import com.egeuniversity.LanguageLearning.Service.Question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        super();
        this.questionService = questionService;
    }

    @GetMapping("/questions")
    public List<Question> getQuestions(){
        return questionService.listQuestions();
    }

    @GetMapping("question/{id}")
    public Question getQuestion(@PathVariable String id){
        return questionService.getQuestion(id);
    }

}
