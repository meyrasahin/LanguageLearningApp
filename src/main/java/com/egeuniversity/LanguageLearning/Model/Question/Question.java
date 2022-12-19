package com.egeuniversity.LanguageLearning.Model.Question;

import com.egeuniversity.LanguageLearning.Model.Generic.BaseEntity;
import com.egeuniversity.LanguageLearning.Model.LevelUpExam.LevelUpExam;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name="QUESTION")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Question extends BaseEntity<Integer, Question> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "OPTION1")
    private String option1;

    @Column(name = "OPTION2")
    private String option2;

    @Column(name = "OPTION3")
    private String option3;

    @Column(name = "OPTION4")
    private String option4;

    @Column(name = "ANSWER")
    private String answer;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "levelUpExam_id", referencedColumnName = "ID")
    private LevelUpExam levelUpExam;
}
