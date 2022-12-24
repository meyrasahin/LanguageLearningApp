package com.egeuniversity.LanguageLearning.Controller;

import com.egeuniversity.LanguageLearning.Model.Course.Course;
import com.egeuniversity.LanguageLearning.Model.Exam.Exam;
import com.egeuniversity.LanguageLearning.Model.Exam.ExamDTO;
import com.egeuniversity.LanguageLearning.Model.Trainee.Trainee;
import com.egeuniversity.LanguageLearning.Service.Course.CourseService;
import com.egeuniversity.LanguageLearning.Service.Exam.ExamService;
import com.egeuniversity.LanguageLearning.Service.Trainee.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExamController {

    @Autowired
    private TraineeService traineeService;

    @Autowired
    private CourseService courseService;

    private ExamService examService;

    @Autowired
    public ExamController(ExamService examService) {
        super();
        this.examService = examService;
    }

    @PostMapping("/result")
    public ModelAndView getResult(@RequestBody ExamDTO examDTO){
        ModelAndView model;
        Exam exam = examService.calculateResult(examDTO);
        int score = Integer.parseInt(exam.getGrade());
        model = score < 50 ? new ModelAndView("result-fail") : new ModelAndView("result-success");

        Trainee trainee = traineeService.getById(1);
        model.addObject("trainee", trainee);

        model.addObject("grade", exam.getGrade());
        model.addObject("correct", exam.getTrueAnswers());
        model.addObject("incorrect", exam.getFalseAnswers());
        model.addObject("examTitle", courseService.getById(examDTO.getCourseId()).getName());

        return model;

    }

    @GetMapping("exam-start/{courseId}")
    public String getExam(@PathVariable String courseId, Model model) {
        Course course = courseService.getById(courseId);
        model.addAttribute("course", course);

        Trainee trainee = traineeService.getById(1);
        model.addAttribute("trainee", trainee);
        return "exam-start";
    }


}
