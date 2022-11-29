package com.egeuniversity.LanguageLearning.Service.Course;

import com.egeuniversity.LanguageLearning.Model.Course.Course;
import com.egeuniversity.LanguageLearning.Repository.Course.CourseRepository;
import com.egeuniversity.LanguageLearning.Service.Generic.BaseEntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl extends BaseEntityServiceImpl<Integer, Course> implements CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        super(courseRepository);
        this.courseRepository = courseRepository;
    }

    @Override
    public Course getById(String id) {
        return courseRepository.getOne(Integer.valueOf(id));
    }
}
