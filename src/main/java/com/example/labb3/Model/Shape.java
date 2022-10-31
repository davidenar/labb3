package com.example.labb3.Model;

import javafx.scene.paint.Color;

public class Shape {

    private Color color;
    private Position position;
}

record Position(int x, int y) {
}
