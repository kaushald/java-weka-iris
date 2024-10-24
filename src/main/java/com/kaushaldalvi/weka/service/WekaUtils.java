package com.kaushaldalvi.weka.service;

import weka.core.Attribute;
import java.util.ArrayList;

public class WekaUtils {

    public static ArrayList<Attribute> createIrisAttributes() {
        ArrayList<Attribute> attributes = new ArrayList<>();

        // Define numeric attributes
        attributes.add(new Attribute("sepal_length"));
        attributes.add(new Attribute("sepal_width"));
        attributes.add(new Attribute("petal_length"));
        attributes.add(new Attribute("petal_width"));

        // Define class attribute
        ArrayList<String> classValues = new ArrayList<>();
        classValues.add("Iris-setosa");
        classValues.add("Iris-versicolor");
        classValues.add("Iris-virginica");
        attributes.add(new Attribute("class", classValues));

        return attributes;
    }
}