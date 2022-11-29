package com.egeuniversity.LanguageLearning.Model.Course;

import com.egeuniversity.LanguageLearning.Model.Generic.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name="COURSE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course extends BaseEntity<Integer, Course> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CURRENT_LEVEL")
    private String currentLevel;

    @Column(name = "PRE_LEVEL")
    private String previousLevel;

    @Column(name = "NEXT_LEVEL")
    private String nextLevel;

    @Column(name = "LECTURER")
    private String lecturerName;
}
