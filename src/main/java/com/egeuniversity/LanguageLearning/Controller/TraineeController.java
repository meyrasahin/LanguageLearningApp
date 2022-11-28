package com.egeuniversity.LanguageLearning.Controller;

import com.egeuniversity.LanguageLearning.Service.Trainee.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trainee")
public class TraineeController {
    private TraineeService traineeService;


    @Autowired
    public TraineeController(TraineeService traineeService) {
        super();
        this.traineeService = traineeService;
    }

    @GetMapping("/get")
    public String getByName(){
        return traineeService.findByName("meyr2a").getName();
    }
}
