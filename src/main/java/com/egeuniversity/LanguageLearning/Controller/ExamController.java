package com.egeuniversity.LanguageLearning.Controller;

import com.egeuniversity.LanguageLearning.Model.Exam.ExamDTO;
import com.egeuniversity.LanguageLearning.Service.Exam.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exam")
public class ExamController {

    private ExamService examService;

    @Autowired
    public ExamController(ExamService examService) {
        super();
        this.examService = examService;
    }

    @PostMapping("/result")
    public int getResult(@RequestBody ExamDTO examDTO){
        return examService.calculateResult(examDTO);
    }


}
