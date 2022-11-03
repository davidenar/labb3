package com.example.labb3.Model;


import java.util.ArrayList;
import java.util.List;

public class PabloModel {

    public static ArrayList<Shape> shapesList = new ArrayList<>();

    public void addShape(Shape shape) {
        shapesList.add(shape);
    }

    public List getShapes() {
        return shapesList;
    }

// method for drawing canvas based on data from arraylist

}
