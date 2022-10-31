package com.example.labb3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PabloController {
    public Canvas canvas;
    public ColorPicker colorPicker;

    public GraphicsContext context;
    public Slider sizeSlider;

    public void initialize(){
        context=canvas.getGraphicsContext2D();
    }

    public void onCanvasClicked(MouseEvent mouseEvent) {

        context.setFill(colorPicker.getValue());
        context.fillRect(mouseEvent.getX()-(sizeSlider.getValue()/2), mouseEvent.getY()-(sizeSlider.getValue()/2), sizeSlider.getValue(), sizeSlider.getValue());
    }

    public void close(ActionEvent actionEvent) {
        System.exit(0);
    }
}