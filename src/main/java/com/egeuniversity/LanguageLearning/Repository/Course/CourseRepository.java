package com.egeuniversity.LanguageLearning.Repository.Course;

import com.egeuniversity.LanguageLearning.Model.Course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
