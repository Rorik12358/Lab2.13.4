package com.brainacad.oop.testshapes2_13;

/**
 * Created by R2-D2 on 28.02.2016.
 */
public abstract class Shape implements Drawable {
    private String shapeColor;

    public Shape(String shapeColor) {
        this.shapeColor = shapeColor.toUpperCase();
    }

    //Lab 2.13.4
    public static Shape parseShape(String shapeInput) throws InvalidShapeStringException {
        Shape shape;
        try {
            shape = Rectangle.parseRectangle(shapeInput);
        } catch (InvalidShapeStringException e) {
            try {
                shape = Triangle.parseTriangle(shapeInput);
            } catch (InvalidShapeStringException e1) {
                shape = Circle.parseCircle(shapeInput);
            }
        }
        return shape;
    }

    @Override
    public String toString() {
        return "Shape, color is: " + shapeColor;
    }

    public abstract double calcArea();

    public String getShapeColor() {
        return shapeColor;
    }
}
