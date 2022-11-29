package com.egeuniversity.LanguageLearning.Model.Question;

import com.egeuniversity.LanguageLearning.Model.Generic.BaseEntity;
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

    @Column(name = "ANSWER")
    private String answer;
}
