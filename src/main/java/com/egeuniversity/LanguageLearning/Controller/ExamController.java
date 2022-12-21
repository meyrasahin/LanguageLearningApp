package com.egeuniversity.LanguageLearning.Controller;

import com.egeuniversity.LanguageLearning.Model.Exam.ExamDTO;
import com.egeuniversity.LanguageLearning.Service.Exam.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ExamController {

    private ExamService examService;

    @Autowired
    public ExamController(ExamService examService) {
        super();
        this.examService = examService;
    }

    @PostMapping("/result")
    public String getResult(@RequestBody ExamDTO examDTO, Model model){
        int grade = examService.calculateResult(examDTO);
        model.addAttribute("grade", grade);
        return "result";
    }

    @GetMapping("exam/start")
    public String getExam() {
        return "exam-start";
    }


}
