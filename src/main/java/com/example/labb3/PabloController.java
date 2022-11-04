package com.example.labb3;

import com.example.labb3.Model.PabloModel;
import com.example.labb3.Model.Shape;
import com.example.labb3.Model.ShapeType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class PabloController {
    public PabloModel model = new PabloModel();
    public Canvas canvas;
    public GraphicsContext context;
    public ColorPicker colorPicker;
    public Slider sizeSlider;
    public ChoiceBox<ShapeType> choiceBox;
    public ToggleButton selectModeButton;


    ObservableList<ShapeType> shapeTypesList = FXCollections.observableArrayList(ShapeType.values());

    public void initialize() {
        context = canvas.getGraphicsContext2D();
        colorPicker.valueProperty().bindBidirectional(model.currentColorProperty());
        sizeSlider.valueProperty().bindBidirectional(model.currentSizeProperty());
        choiceBox.setItems(shapeTypesList);
        choiceBox.valueProperty().bindBidirectional(model.currentShapeTypeProperty());
        selectModeButton.selectedProperty().bindBidirectional(model.selectModeProperty());
    }


    public void onCanvasClicked(MouseEvent mouseEvent) {
        if (model.isSelectMode()) {
            for (Shape s : model.getShapes()) {
                if (s.isSelected(s.getX(), s.getY())) {
                    model.getSelectedShapes().add(s);
                }

            }

        }
        Shape shape = Shape.createShape(model.getCurrentShapeType(), mouseEvent.getX(), mouseEvent.getY(), model.getCurrentSize(), model.getCurrentColor());
        model.addShape(shape);
        {
            var context = canvas.getGraphicsContext2D();
            for (Shape s : model.getShapes()) {
                s.draw(context);
            }
        }
    }
}
