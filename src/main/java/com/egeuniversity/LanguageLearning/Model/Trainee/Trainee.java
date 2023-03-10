package com.egeuniversity.LanguageLearning.Model.Trainee;

import com.egeuniversity.LanguageLearning.Model.Course.Course;
import com.egeuniversity.LanguageLearning.Model.Generic.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name="TRAINEE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Trainee extends BaseEntity<Integer, Trainee> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "EMAIL")
    private String email;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Course.class)
    @JoinColumn(name = "COURSE_ID")
    private Course course;

}
