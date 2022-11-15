package com.example.labb3;

import com.example.labb3.model.PabloModel;
import com.example.labb3.model.Shape;
import com.example.labb3.model.ShapeType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class PabloController {
    public PabloModel model = new PabloModel();
    public Canvas canvas;
    public GraphicsContext context;
    public ColorPicker colorPicker;
    public Slider sizeSlider;
    public ChoiceBox<ShapeType> choiceBox;
    public ToggleButton selectModeButton;
    public Button executeButton;
    public Button saveButton;

    public Stage stage;
    public Button undoButton;


    ObservableList<ShapeType> shapeTypesList = FXCollections.observableArrayList(ShapeType.values());

    public void initialize() {
        context = canvas.getGraphicsContext2D();
        colorPicker.valueProperty().bindBidirectional(model.currentColorProperty());
        sizeSlider.valueProperty().bindBidirectional(model.currentSizeProperty());
        choiceBox.setItems(shapeTypesList);
        choiceBox.valueProperty().bindBidirectional(model.currentShapeTypeProperty());
        selectModeButton.selectedProperty().bindBidirectional(model.selectModeProperty());
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void onCanvasClicked(MouseEvent mouseEvent) {
        if (model.isSelectMode()) {
            for (Shape s : model.getShapes()) {
                if (s.isSelected(mouseEvent.getX(), mouseEvent.getY())) {
                    model.getSelectedShapes().add(s);
                    for (Shape t :
                            model.getSelectedShapes()) {
                        System.out.println(t);
                    }
                }

            }

        } else {
            Shape shape = Shape.createShape(model.getCurrentShapeType(), mouseEvent.getX(), mouseEvent.getY(), model.getCurrentSize(), model.getCurrentColor());
            model.addShape(shape);
        }
        {
            drawController();
        }
    }

    @FXML
    void executeChanges(ActionEvent mouseEvent) {
        model.modifySelectedShape();
        drawController();
        model.resetSelectedShapes();
    }

    void drawController() {
        var context = canvas.getGraphicsContext2D();

        context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (Shape s : model.getShapes()) {
            s.draw(context);
        }
    }

    public void onUndoButton(ActionEvent actionEvent) {
        model.undo();
        drawController();
    }

    public void onSaveButtonAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save as");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().clear();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("SVG", "*.svg"));

        File filePath = fileChooser.showSaveDialog(stage);

        if (filePath != null)
            model.saveToFile(filePath.toPath());
    }
}