package com.example.labb3.Model;


import javafx.beans.property.*;
import javafx.scene.paint.Color;


import java.util.ArrayList;

public class PabloModel {

    ObjectProperty<Color> currentColor = new SimpleObjectProperty<>();
    DoubleProperty currentSize = new SimpleDoubleProperty();
    ObjectProperty<ShapeType> currentShapeType = new SimpleObjectProperty<>(ShapeType.CIRCLE);
    BooleanProperty selectMode = new SimpleBooleanProperty();

    public BooleanProperty selectModeProperty(){
        return selectMode;
    }

    public boolean isSelectMode() {
        return selectMode.get();
    }

    public static ArrayList<Shape> shapesList = new ArrayList<>();
    public static ArrayList<Shape> selectedShapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapesList.add(shape);
    }

    public ArrayList<Shape> getSelectedShapes() {
        return selectedShapes;
    }

    public ShapeType getCurrentShapeType() {
        return currentShapeType.get();
    }

    public ObjectProperty<ShapeType> currentShapeTypeProperty() {
        return currentShapeType;
    }

    public void setCurrentShapeType(ShapeType currentShapeType) {
        this.currentShapeType.set(currentShapeType);
    }


    public ArrayList<Shape> getShapes() {
        return shapesList;
    }

    public Color getCurrentColor() {
        return currentColor.get();
    }

    public ObjectProperty<Color> currentColorProperty() {
        return currentColor;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor.set(currentColor);
    }

    public double getCurrentSize() {
        return currentSize.get();
    }

    public DoubleProperty currentSizeProperty() {
        return currentSize;
    }

    public void setCurrentSize(double currentSize) {
        this.currentSize.set(currentSize);
    }
}
