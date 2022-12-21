package com.egeuniversity.LanguageLearning.Service.Exam;

import com.egeuniversity.LanguageLearning.Model.Course.Course;
import com.egeuniversity.LanguageLearning.Model.Exam.Exam;
import com.egeuniversity.LanguageLearning.Model.Exam.ExamDTO;
import com.egeuniversity.LanguageLearning.Model.LevelUpExam.LevelUpExam;
import com.egeuniversity.LanguageLearning.Model.Trainee.Trainee;
import com.egeuniversity.LanguageLearning.Repository.Exam.ExamRepository;
import com.egeuniversity.LanguageLearning.Service.Course.CourseService;
import com.egeuniversity.LanguageLearning.Service.Generic.BaseEntityServiceImpl;
import com.egeuniversity.LanguageLearning.Service.Trainee.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl extends BaseEntityServiceImpl<Integer, Exam> implements ExamService {

    @Autowired
    private CourseService courseService;

    @Autowired
    private TraineeService traineeService;

    private ExamRepository examRepository;

    @Autowired
    public ExamServiceImpl(ExamRepository examRepository) {
        super(examRepository);
        this.examRepository = examRepository;
    }

    @Override
    public Exam calculateResult(ExamDTO examDTO) {
        Course course = courseService.getById(examDTO.getCourseId());
        LevelUpExam levelUpExam = course.getLevelUpExam();
        List<String> traineeAnswers = List.of(examDTO.getTraineeAnswers().split(","));
        Trainee trainee = traineeService.getById(examDTO.getTraineeId());

        int correct = 0;

        for (int i = 0; i < traineeAnswers.size(); i++) {
            if(levelUpExam.getQuestions().get(i).getAnswer().equals(traineeAnswers.get(i))){
                correct += 1;
            }
        }

        Exam exam = new Exam();
        exam.setLevelUpExam(levelUpExam);
        exam.setGrade(String.valueOf(correct * 5));
        exam.setTrueAnswers(String.valueOf(correct));
        exam.setFalseAnswers(String.valueOf(traineeAnswers.size() - correct));
        exam.setTrainee(trainee);
        exam.setAnswers(examDTO.getTraineeAnswers());

        examRepository.save(exam);

        return exam;
    }
}
