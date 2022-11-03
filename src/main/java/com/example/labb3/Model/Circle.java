package com.example.labb3.Model;

import javafx.scene.paint.Color;

public class Circle extends Shape{

    public Circle(double x, double y, double size, Color color) {
        super(x, y, size, color);
        this.x=x;
        this.y=y;
        this.size=size;
        this.color=color;
    }
}
