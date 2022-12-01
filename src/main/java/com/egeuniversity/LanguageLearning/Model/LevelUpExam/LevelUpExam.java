package com.egeuniversity.LanguageLearning.Model.LevelUpExam;

import com.egeuniversity.LanguageLearning.Model.Generic.BaseEntity;
import com.egeuniversity.LanguageLearning.Model.Question.Question;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="LEVELUP_EXAM")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LevelUpExam extends BaseEntity<Integer, LevelUpExam> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    @Column(name = "TITLE")
    private String title;

    @OneToMany(mappedBy = "levelUpExam", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Question> questions = new ArrayList<>();

}
