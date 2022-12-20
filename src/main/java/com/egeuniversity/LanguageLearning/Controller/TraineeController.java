package com.egeuniversity.LanguageLearning.Controller;

import com.egeuniversity.LanguageLearning.Model.Trainee.Trainee;
import com.egeuniversity.LanguageLearning.Service.Trainee.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TraineeController {

    private TraineeService traineeService;

    @Autowired
    public TraineeController(TraineeService traineeService) {
        super();
        this.traineeService = traineeService;
    }

    @GetMapping("/trainee/{id}")
    public String getById(@PathVariable String id){
        return traineeService.findById(id).getName();
    }

    @GetMapping("/trainees")
    public List<Trainee> getTrainees(){
        return traineeService.listTrainees();
    }
}
