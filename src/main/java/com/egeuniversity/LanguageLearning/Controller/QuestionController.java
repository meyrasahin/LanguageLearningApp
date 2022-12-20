package com.egeuniversity.LanguageLearning.Controller;

import com.egeuniversity.LanguageLearning.Model.Question.Question;
import com.egeuniversity.LanguageLearning.Service.Question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String getQuestions(Model model){
        List<Question> questions = questionService.listQuestions();
        model.addAttribute("questions", questions);
        return "index";
    }

    @GetMapping("question/{id}")
    public String getQuestion(@PathVariable String id, Model model){
        Question question = questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "index";
    }

}
