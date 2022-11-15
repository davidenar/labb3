package com.example.labb3.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends Shape {

    public Square(double x, double y, double size, Color color) {
        super(x, y, size, color);
    }

    @Override
    public void draw(GraphicsContext context) {

        context.setFill(getColor());
        context.fillRect(getX() - (getSize() / 2), getY() - (getSize() / 2), getSize(), getSize());
    }

    @Override
    public boolean isSelected(double x, double y) {
        double xEdge = getX() - (getSize() / 2);
        double yEdge = getY() - (getSize() / 2);

        return x >= xEdge &&
                x <= xEdge + ((getSize())) &&
                y >= yEdge &&
                y <= yEdge + ((getSize()));
    }
}