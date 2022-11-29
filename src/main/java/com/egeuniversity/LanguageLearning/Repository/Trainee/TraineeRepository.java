package com.egeuniversity.LanguageLearning.Repository.Trainee;

import com.egeuniversity.LanguageLearning.Model.Trainee.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraineeRepository extends JpaRepository<Trainee, Integer> {
    //@Query("select Trainee From Trainee where name=:nameParam ")
    public Trainee findByName(String nameParam);

}
