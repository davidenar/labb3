package com.example.model;

import com.example.labb3.PabloController;
import com.example.labb3.model.Circle;
import com.example.labb3.model.PabloModel;
import com.example.labb3.model.Shape;
import com.example.labb3.model.ShapeType;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;


import javafx.scene.canvas.Canvas;

import static org.junit.jupiter.api.Assertions.*;


class PabloModelTest {

    PabloModel model = new PabloModel();
    Shape circle = new Circle(200, 200, 10, Color.RED);

    @Test
    void addShapeAddsOneShapeToShapesList() {

        int expected = model.getShapes().size() + 1;
        model.addShape(circle);
        int actual = model.getShapes().size();
        assertEquals(expected, actual);
    }

    @Test
    void undoRemovesOneShapeFromShapesList() {

        model.addShape(circle);
        int expected = model.getShapes().size()-1;
        model.undo();
        int actual = model.getShapes().size();
        assertEquals(expected, actual);


    }

}