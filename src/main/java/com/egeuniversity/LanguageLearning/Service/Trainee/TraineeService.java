package com.egeuniversity.LanguageLearning.Service.Trainee;

import com.egeuniversity.LanguageLearning.Model.Trainee.Trainee;
import com.egeuniversity.LanguageLearning.Service.Generic.BaseEntityService;

public interface TraineeService extends BaseEntityService<Integer, Trainee> {
    Trainee findByName(String name);
}
