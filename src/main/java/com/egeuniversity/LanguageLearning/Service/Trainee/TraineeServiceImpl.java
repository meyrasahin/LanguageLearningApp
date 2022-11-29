package com.egeuniversity.LanguageLearning.Service.Trainee;

import com.egeuniversity.LanguageLearning.Model.Trainee.Trainee;
import com.egeuniversity.LanguageLearning.Repository.Trainee.TraineeRepository;
import com.egeuniversity.LanguageLearning.Service.Generic.BaseEntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraineeServiceImpl extends BaseEntityServiceImpl<Integer, Trainee> implements TraineeService {

    private TraineeRepository traineeRepository;

    @Autowired
    public TraineeServiceImpl(TraineeRepository traineeRepository) {
        super(traineeRepository);
        this.traineeRepository = traineeRepository;
    }

    @Override
    public Trainee findById(String id) {
        return traineeRepository.getOne(Integer.valueOf(id));
    }

    @Override
    public List<Trainee> listTrainees() {
        return traineeRepository.findAll();
    }
}
