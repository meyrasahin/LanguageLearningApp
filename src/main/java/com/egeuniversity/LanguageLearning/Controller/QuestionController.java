package com.egeuniversity.LanguageLearning.Controller;

import com.egeuniversity.LanguageLearning.Model.Course.Course;
import com.egeuniversity.LanguageLearning.Model.Question.Question;
import com.egeuniversity.LanguageLearning.Model.Trainee.Trainee;
import com.egeuniversity.LanguageLearning.Service.Course.CourseService;
import com.egeuniversity.LanguageLearning.Service.Question.QuestionService;
import com.egeuniversity.LanguageLearning.Service.Trainee.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Comparator;
import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private TraineeService traineeService;

    @Autowired
    private CourseService courseService;

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        super();
        this.questionService = questionService;
    }

    @GetMapping("/exam/course{courseId}")
    public String getQuestions(@PathVariable String courseId, Model model){
        Trainee trainee = traineeService.getById(1);
        model.addAttribute("trainee", trainee);

        List<Question> questions = questionService.listQuestionsByCourse(courseId);
        questions.sort(Comparator.comparing(Question::getId));
        model.addAttribute("questions", questions);

        Course course = courseService.getById(courseId);
        model.addAttribute("title", course.getName());
        model.addAttribute("courseId", course.getId());
        return "question";
    }

    @GetMapping("question/{id}")
    public String getQuestion(@PathVariable String id, Model model){
        Question question = questionService.getQuestion(id);
        model.addAttribute("question", question);

        Trainee trainee = traineeService.getById(1);
        model.addAttribute("trainee", trainee);
        return "question";
    }

}
