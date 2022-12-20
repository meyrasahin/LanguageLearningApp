package com.egeuniversity.LanguageLearning.Controller;

import com.egeuniversity.LanguageLearning.Model.Course.Course;
import com.egeuniversity.LanguageLearning.Service.Course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CourseController {

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
        model.addAttribute("courses", courseList);
        return "courses";
    }

}
