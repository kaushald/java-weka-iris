package com.kaushaldalvi.weka.service;


import org.springframework.stereotype.Service;
import weka.classifiers.Classifier;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.SerializationHelper;
import weka.core.Instances;

import java.io.InputStream;
import java.util.ArrayList;

@Service
public class PredictionService {
    private Classifier classifier;
    private Instances dataset;

    public PredictionService() {
        try {
            // Load the model from the resources directory
            InputStream modelStream = getClass().getResourceAsStream("/iris.model");
            classifier = (Classifier) SerializationHelper.read(modelStream);

            // Initialize dataset structure
            dataset = new Instances("IrisInstances", WekaUtils.createIrisAttributes(), 1);
            dataset.setClassIndex(dataset.numAttributes() - 1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String predict(double sepalLength, double sepalWidth, double petalLength, double petalWidth) {
        try {
            // Create instance for prediction
            Instance instance = new DenseInstance(5);
            instance.setValue(dataset.attribute(0), sepalLength);
            instance.setValue(dataset.attribute(1), sepalWidth);
            instance.setValue(dataset.attribute(2), petalLength);
            instance.setValue(dataset.attribute(3), petalWidth);
            instance.setDataset(dataset);

            // Predict the class index
            double predictionIndex = classifier.classifyInstance(instance);
            return dataset.classAttribute().value((int) predictionIndex);

        } catch (Exception e) {
            e.printStackTrace();
            return "Prediction Error";
        }
    }
}