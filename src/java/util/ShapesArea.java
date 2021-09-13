/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author rocha
 */
public class ShapesArea {
    
    public static double computeAreaTriangle(double base, double height) throws NegativeValuesException {

        if (base < 0 || height < 0) {
            throw new NegativeValuesException();
        } 

        return 0.5 * base * height;
    }

    public static double computeAreaRectangle(double width, double height) throws NegativeValuesException {
        if (width < 0 || height < 0) {
            throw new NegativeValuesException();
        } 

        return width * height;
    }

    public static double computeAreaTrapezoid(double minorBase, double majorBase, double height) throws NegativeValuesException {
        if (minorBase < 0 || majorBase < 0 || height < 0) {
            throw new NegativeValuesException();
        } 

        return 0.5 * (minorBase + majorBase) * height;
    }

    public static double computeAreaEllipse(double major, double minor) throws NegativeValuesException {
        if (major < 0 || minor < 0) {
            throw new NegativeValuesException();
        } 
        
        return 3.14 * major * minor;
    }

    public static double computeAreaSquare(double side) throws NegativeValuesException {
        if (side < 0) {
            throw new NegativeValuesException();
        } 

        return side * side;
    }

    public static double computeAreaParallelogram(double base, double height) throws NegativeValuesException {
        if (base < 0 || height < 0) {
            throw new NegativeValuesException();
        } 

        return base * height;
    }

    public static double computeAreaCircle(double radius) throws NegativeValuesException {
        if (radius < 0) {
            throw new NegativeValuesException();
        } 

        return 3.14 * radius * radius;
    }

    public static double computeAreaSector(double radius, double angle) throws NegativeValuesException {
        if (radius < 0 || angle < 0) {
            throw new NegativeValuesException();
        } 

        return 0.5 * radius * radius * angle;
    }
    
}
