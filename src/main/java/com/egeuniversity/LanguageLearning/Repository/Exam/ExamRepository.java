package com.egeuniversity.LanguageLearning.Repository.Exam;

import com.egeuniversity.LanguageLearning.Model.Exam.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository  extends JpaRepository<Exam, Integer> {
}
