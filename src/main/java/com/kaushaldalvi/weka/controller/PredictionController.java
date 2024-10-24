package com.kaushaldalvi.weka.controller;


import com.kaushaldalvi.weka.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PredictionController {

    @Autowired
    private PredictionService predictionService;

    @GetMapping("/predict")
    public String predict(
            @RequestParam double sepalLength,
            @RequestParam double sepalWidth,
            @RequestParam double petalLength,
            @RequestParam double petalWidth) {

        return predictionService.predict(sepalLength, sepalWidth, petalLength, petalWidth);
    }
}
