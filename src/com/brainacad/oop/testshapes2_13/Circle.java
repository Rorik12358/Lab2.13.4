package com.brainacad.oop.testshapes2_13;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by R2-D2 on 28.02.2016.
 */
public class Circle extends Shape implements Comparable {
    private double radius;

    public Circle(String shapeColor, double radius) {
        super(shapeColor);
        this.radius = radius;
    }

    public static Circle parseCircle(String input) throws InvalidShapeStringException {
        String regex = "(Rectangle|Triangle|Circle):[A-Z]+:([1-9]\\d*,)*[1-9]\\d*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new InvalidShapeStringException();
        }
        StringTokenizer stringTokenizer = new StringTokenizer(input, ":,");
        if (stringTokenizer.nextToken().equals("Circle")) {
            String color = stringTokenizer.nextToken();
            double radious = Double.parseDouble(stringTokenizer.nextToken());
            return new Circle(color, radious);
        } else throw new InvalidShapeStringException();
    }

    @Override
    public double calcArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        //“This is Circle, color: GREEN, radius=22”
        return "This is Circle, color: " + super.getShapeColor() + ", radius=" + radius;
    }

    @Override
    // This is Rectangle, color: RED, width=11, height=22,  area is: 242
    public void draw() {
        System.out.println(this.toString() + " area is: " + calcArea());
    }

    @Override
    public int compareTo(Object o) {
        Circle circle = (Circle) o;
        if (this.calcArea() > circle.calcArea()) return 1;
        if (this.calcArea() < circle.calcArea()) return -1;
        return 0;
    }
}
