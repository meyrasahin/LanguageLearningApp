package com.egeuniversity.LanguageLearning.Service.Trainee;

import com.egeuniversity.LanguageLearning.Model.Trainee.Trainee;
import com.egeuniversity.LanguageLearning.Service.Generic.BaseEntityService;

import java.util.List;

public interface TraineeService extends BaseEntityService<Integer, Trainee> {
    Trainee findById(String name);
    List<Trainee> listTrainees();
}
