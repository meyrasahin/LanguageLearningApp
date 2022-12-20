package com.egeuniversity.LanguageLearning.Controller;

import com.egeuniversity.LanguageLearning.Model.Trainee.Trainee;
import com.egeuniversity.LanguageLearning.Service.Trainee.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String getById(@PathVariable String id, Model model){
        Trainee trainee = traineeService.findById(id);
        model.addAttribute("trainee", trainee);
        return "index";
    }

    @GetMapping("/trainees")
    public String getTrainees(Model model){
        List<Trainee> traineeList = traineeService.listTrainees();
        model.addAttribute("trainees", traineeList);
        return "index";
    }
}
