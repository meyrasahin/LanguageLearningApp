package com.egeuniversity.LanguageLearning.Service.Course;

import com.egeuniversity.LanguageLearning.Model.Course.Course;
import com.egeuniversity.LanguageLearning.Service.Generic.BaseEntityService;

import java.util.List;

public interface CourseService extends BaseEntityService<Integer, Course> {
    Course getById(String id);
    List<Course> list();
}
