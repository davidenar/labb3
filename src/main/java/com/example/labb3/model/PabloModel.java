package com.example.labb3.model;


import javafx.beans.property.*;
import javafx.scene.paint.Color;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class PabloModel {

    ObjectProperty<Color> currentColor = new SimpleObjectProperty<>();
    DoubleProperty currentSize = new SimpleDoubleProperty();
    ObjectProperty<ShapeType> currentShapeType = new SimpleObjectProperty<>(ShapeType.CIRCLE);
    BooleanProperty selectMode = new SimpleBooleanProperty();

    public BooleanProperty selectModeProperty() {
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

    public void modifySelectedShape() {
        for (Shape s : selectedShapes) {
            s.setColor(getCurrentColor());
            s.setSize(getCurrentSize());
        }
    }

    public void saveToFile(Path file) {
        StringBuilder sb = new StringBuilder();

        sb.append("<svg version=\"1.1\" width=\"600\" height=\"600\" xmlns=\"http://www.w3.org/2000/svg\">\n");

        for (Shape s : shapesList) {
            if (s instanceof Circle) {

                sb.append("<circle cx=\"").append(s.getX()).
                        append("\" cy=\"").append(s.getY()).
                        append("\" r=\"").append(s.getSize() / 2).
                        append("\" stroke=\"").append(toHexString(s.getColor())).
                        append("\" fill=\"").append(toHexString(s.getColor())).
                        append("\" stroke-width=\"1\"").
                        append("/>\n");

            } else if (s instanceof Square) {
                sb.append("<rect cx=\"").append(s.getX()).
                        append("\" cy=\"").append(s.getY()).
                        append("\" width=\"").append(s.getSize()).
                        append("\" height=\"").append(s.getSize()).
                        append("\" stroke=\"").append(toHexString(s.getColor())).
                        append("\" fill=\"").append(toHexString(s.getColor())).
                        append("\" stroke-width=\"1\"").
                        append("/>\n");
            }
        }
        sb.append("</svg>");
        try {
            FileWriter writeFile = new FileWriter(file.toFile());

            writeFile.write(sb.toString());

            writeFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String format(double val) {
        String in = Integer.toHexString((int) Math.round(val * 255));
        return in.length() == 1 ? "0" + in : in;
    }

    public String toHexString(Color value) {
        return "#" + (format(value.getRed()) + format(value.getGreen()) + format(value.getBlue()) + format(value.getOpacity()))
                .toUpperCase();
    }
    public void undo() {
        shapesList.remove(shapesList.size() - 1);
    }

    public void resetSelectedShapes() {
        selectedShapes.clear();
    }
}
