package com.egeuniversity.LanguageLearning.Model.Trainee;

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


}
