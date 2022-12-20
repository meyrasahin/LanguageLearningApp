package com.egeuniversity.LanguageLearning.Controller;

import com.egeuniversity.LanguageLearning.Model.Course.Course;
import com.egeuniversity.LanguageLearning.Model.Trainee.Trainee;
import com.egeuniversity.LanguageLearning.Service.Course.CourseService;
import com.egeuniversity.LanguageLearning.Service.Trainee.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Comparator;
import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private TraineeService traineeService;

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        super();
        this.courseService = courseService;
    }

    @GetMapping("/course/{id}")
    public String getById(@PathVariable String id, Model model){
        Course course = courseService.getById(id);
        model.addAttribute("course", course);
        return "course";
    }

    @GetMapping("/courses")
    public String getAllCourses(Model model) {
        List<Course> courseList = courseService.list();
        courseList.sort(Comparator.comparing(Course::getId));
        model.addAttribute("courses", courseList);

        Trainee trainee = traineeService.getById(1);
        model.addAttribute("trainee", trainee);
        return "courses";
    }

}
