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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
        ExamDTO examDTO = new ExamDTO("A,A,A,B,B,B,B,B,A,A,A,A,B,C,A,A,A,B,A,A",1,1);
        //"C,D,C,A,D,C,A,C,B,D,C,B,B,C,A,A,A,A,A,A"
        Trainee trainee = traineeService.getById(1);
        model.addAttribute("trainee", trainee);

        Exam exam = examService.calculateResult(examDTO);
        model.addAttribute("grade", exam.getGrade());
        model.addAttribute("correct", exam.getTrueAnswers());
        model.addAttribute("incorrect", exam.getFalseAnswers());
        model.addAttribute("examTitle", exam.getLevelUpExam().getTitle());
        int score = Integer.parseInt(exam.getGrade());
        if (score > 49) {
            return "result-success";
        } else if (score < 50) {
            return "result-fail";
        }
        else {
            return "result-fail";
        }

    }

    @GetMapping("exam/start")
    public String getExam() {
        return "exam-start";
    }


}
