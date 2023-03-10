package com.egeuniversity.LanguageLearning.Service.Question;

import com.egeuniversity.LanguageLearning.Model.Course.Course;
import com.egeuniversity.LanguageLearning.Model.Question.Question;
import com.egeuniversity.LanguageLearning.Repository.Question.QuestionRepository;
import com.egeuniversity.LanguageLearning.Service.Course.CourseService;
import com.egeuniversity.LanguageLearning.Service.Generic.BaseEntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl extends BaseEntityServiceImpl<Integer, Question> implements QuestionService {

    @Autowired
    private CourseService courseService;

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        super(questionRepository);
        this.questionRepository = questionRepository;
    }


    @Override
    public List<Question> listQuestionsByCourse(String courseId) {
        Course course = courseService.getById(courseId);
        return course.getLevelUpExam().getQuestions();
    }

    @Override
    public List<Question> listQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestion(String id) {
        return questionRepository.findById(Integer.valueOf(id)).orElse(null);
    }
}
