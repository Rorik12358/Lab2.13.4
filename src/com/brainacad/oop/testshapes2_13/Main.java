package com.brainacad.oop.testshapes2_13;

import java.util.Scanner;

/**
 * Created by R2-D2 on 28.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        try {
            Rectangle rectangle2_10_4 = (Rectangle) Shape.parseShape("Rectangle:RED:10,20");
            System.out.println(rectangle2_10_4);
        } catch (InvalidShapeStringException e) {
            e.printStackTrace();
        }
        try {
            Triangle triangle2_10_4 = (Triangle) Shape.parseShape("Triangle:YELLOW:12,55,12");
            System.out.println(triangle2_10_4);
        } catch (InvalidShapeStringException e) {
            e.printStackTrace();
        }
        try {
            Circle circle2_10_4 = (Circle) Shape.parseShape("Circle:BLACK:29");
            System.out.println(circle2_10_4);
        } catch (InvalidShapeStringException e) {
            e.printStackTrace();
        }
        // Lab2.13.5
        Scanner scanner = new Scanner(System.in);
        int quantityOfShapes = Integer.parseInt(scanner.nextLine());
        Shape[] shapes = new Shape[quantityOfShapes];
        for (int i = 0; i < quantityOfShapes; i++) {
            String newShape = scanner.nextLine();
            try {
                shapes[i] = Shape.parseShape(newShape);
            } catch (InvalidShapeStringException e) {
                e.printStackTrace();
            }
        }
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
