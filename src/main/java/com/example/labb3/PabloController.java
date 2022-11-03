package com.example.labb3;

import com.example.labb3.Model.PabloModel;
import com.example.labb3.Model.Shape;
import com.example.labb3.Model.ShapeType;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class PabloController {
    public Canvas canvas;
    public ColorPicker colorPicker;

    public GraphicsContext context;

    public PabloModel model = new PabloModel();
    public Slider sizeSlider;

    public void initialize() {
        context = canvas.getGraphicsContext2D();
    }

    public void pickColor(Color color){
        color=colorPicker.getValue();
    }
    public void onCanvasClicked(MouseEvent mouseEvent) {
        Shape shape = Shape.createShape(ShapeType.CIRCLE,mouseEvent.getX() ,mouseEvent.getY(),sizeSlider.getValue(), colorPicker.getValue());
        model.addShape(shape);

        var context = canvas.getGraphicsContext2D();
        for (int i = 0; i < PabloModel.shapesList.size(); i++) {
            context.setFill(PabloModel.shapesList.get(i).getColor());
            context.fillOval(PabloModel.shapesList.get(i).getX()-(PabloModel.shapesList.get(i).getSize()/2), PabloModel.shapesList.get(i).getY()-(PabloModel.shapesList.get(i).getSize()/2), PabloModel.shapesList.get(i).getSize(), PabloModel.shapesList.get(i).getSize());
        }

        }


    public void close(ActionEvent actionEvent) {
        System.exit(0);
    }
}