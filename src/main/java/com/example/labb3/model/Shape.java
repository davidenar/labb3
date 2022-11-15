package com.example.labb3.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {

    ShapeType type;
    double x;
    double y;
    double size;
    Color color;

    public Shape(double x, double y, double size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }


    public void setSize(double size) {
        this.size = size;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    public static Shape createShape(ShapeType type, double x, double y, double size, Color color) {
        return switch (type) {
            case CIRCLE -> new Circle(x, y, size, color);
            case SQUARE -> new Square(x, y, size, color);
        };
    }

    public abstract void draw(GraphicsContext context);

    public abstract boolean isSelected(double x , double y);
}
