package com.egeuniversity.LanguageLearning.Model.Exam;

import com.egeuniversity.LanguageLearning.Model.Generic.BaseEntity;
import com.egeuniversity.LanguageLearning.Model.LevelUpExam.LevelUpExam;
import com.egeuniversity.LanguageLearning.Model.Trainee.Trainee;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name="EXAM")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Exam extends BaseEntity<Integer, Exam> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Trainee.class)
    @JoinColumn(name = "TRAINEE_ID")
    private Trainee trainee;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = LevelUpExam.class)
    @JoinColumn(name = "LEVELUP_EXAM_ID")
    private LevelUpExam levelUpExam;

    @Column(name = "TRAINEE_ANSWERS")
    private String answers;

    @Column(name = "GRADE")
    private String grade;
}
