package com.brainacad.oop.testshapes2_13;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by R2-D2 on 29.02.2016.
 */
public class Rectangle extends Shape implements Comparable {
    private double width;
    private double height;

    public Rectangle(String shapeColor, double width, double height) {
        super(shapeColor);
        this.width = width;
        this.height = height;
    }

    public static Rectangle parseRectangle(String input) throws InvalidShapeStringException {
        String regex = "(Rectangle|Triangle|Circle):[A-Z]+:([1-9]\\d*,)*[1-9]\\d*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new InvalidShapeStringException();
        }
        StringTokenizer stringTokenizer = new StringTokenizer(input, ":,");
        if (stringTokenizer.nextToken().equals("Rectangle")) {
            String color = stringTokenizer.nextToken();
            double width = Double.parseDouble(stringTokenizer.nextToken());
            double height = Double.parseDouble(stringTokenizer.nextToken());
            return new Rectangle(color, width, height);
        } else throw new InvalidShapeStringException();
    }

    @Override
    public double calcArea() {
        return width * height;
    }

    @Override
    //“This is Rectangle, color: RED, width=11, height=22”
    public String toString() {
        return "This is Rectangle, color: " + getShapeColor() + ", width=" + width + ", height=" + height;
    }

    @Override
    // This is Rectangle, color: RED, width=11, height=22,  area is: 242
    public void draw() {
        System.out.println(this.toString() + " area is: " + calcArea());
    }

    @Override
    public int compareTo(Object o) {
        Rectangle rectangle = (Rectangle) o;
        if (this.calcArea() > rectangle.calcArea()) return 1;
        if (this.calcArea() < rectangle.calcArea()) return -1;
        return 0;
    }
}