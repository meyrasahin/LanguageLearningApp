package com.egeuniversity.LanguageLearning.Controller;

import com.egeuniversity.LanguageLearning.Model.Trainee.Trainee;
import com.egeuniversity.LanguageLearning.Service.Trainee.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/trainee")
public class TraineeController {

    private TraineeService traineeService;

    @Autowired
    public TraineeController(TraineeService traineeService) {
        super();
        this.traineeService = traineeService;
    }

    @GetMapping("/get/{id}")
    public String getById(@PathVariable String id){
        return traineeService.findById(id).getName();
    }

    @GetMapping("/list")
    public List<Trainee> getTrainees(){
        return traineeService.listTrainees();
    }
}
