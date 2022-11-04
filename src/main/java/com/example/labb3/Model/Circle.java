package com.example.labb3.Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {

    public Circle(double x, double y, double size, Color color) {
        super(x, y, size, color);
    }

    @Override
    public void draw(GraphicsContext context) {

        context.setFill(getColor());
        context.fillOval(getX() - (getSize() / 2), getY() - (getSize() / 2), getSize(), getSize());
    }

    @Override
    public boolean isSelected(double x, double y) {
        double xEdge = x - (getX());
        double yEdge = y - (getY());
        double distance = Math.sqrt((xEdge * xEdge) + (yEdge * yEdge));
        return distance <= getSize();
    }

}
