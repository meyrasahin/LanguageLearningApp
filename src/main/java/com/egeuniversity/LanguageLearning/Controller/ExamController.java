package com.egeuniversity.LanguageLearning.Controller;

import com.egeuniversity.LanguageLearning.Model.Exam.Exam;
import com.egeuniversity.LanguageLearning.Model.Exam.ExamDTO;
import com.egeuniversity.LanguageLearning.Model.Trainee.Trainee;
import com.egeuniversity.LanguageLearning.Service.Exam.ExamService;
import com.egeuniversity.LanguageLearning.Service.Trainee.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExamController {

    @Autowired
    private TraineeService traineeService;
    private ExamService examService;

    @Autowired
    public ExamController(ExamService examService) {
        super();
        this.examService = examService;
    }

    @GetMapping("/result")
    public String getResult(Model model){
        ExamDTO examDTO = new ExamDTO("A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A",1,1);

        Trainee trainee = traineeService.getById(1);
        model.addAttribute("trainee", trainee);

        Exam exam = examService.calculateResult(examDTO);
        model.addAttribute("grade", exam.getGrade());
        model.addAttribute("correct", exam.getTrueAnswers());
        model.addAttribute("incorrect", exam.getFalseAnswers());
        model.addAttribute("examTitle", exam.getLevelUpExam().getTitle());
        return "result";
    }


}
