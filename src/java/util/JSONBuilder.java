/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Date;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author rocha
 */

public class JSONBuilder {
    
    public static final String ERROR_MESSAGE_NOT_THE_GOOD_SHAPE = "Not the good Shape";
    
    public static String formsList() {
        JSONArray shapesList = new JSONArray();
        JSONObject singleShape = new JSONObject();
        
        singleShape.accumulate("name", "Circle");
        singleShape.accumulate("NumberOfParameters", 1);
        shapesList.add(singleShape);
        singleShape.clear();
        
        singleShape.accumulate("name", "Rectangle");
        singleShape.accumulate("NumberOfParameters", 2);
        shapesList.add(singleShape);
        singleShape.clear();
        
        singleShape.accumulate("name", "Trapezoid");
        singleShape.accumulate("NumberOfParameters", 3);
        shapesList.add(singleShape);
        singleShape.clear();
        
        singleShape.accumulate("name", "Triangle");
        singleShape.accumulate("NumberOfParameters", 2);
        shapesList.add(singleShape);
        singleShape.clear();
        
        singleShape.accumulate("name", "Sector");
        singleShape.accumulate("NumberOfParameters", 2);
        shapesList.add(singleShape);
        singleShape.clear();
        
        singleShape.accumulate("name", "Parallelogram");
        singleShape.accumulate("NumberOfParameters", 2);
        shapesList.add(singleShape);
        singleShape.clear();
        
        singleShape.accumulate("name", "Ellipse");
        singleShape.accumulate("NumberOfParameters", 2);
        shapesList.add(singleShape);
        singleShape.clear();
        
        singleShape.accumulate("name", "Square");
        singleShape.accumulate("NumberOfParameters", 1);
        shapesList.add(singleShape);
        
        return shapesList.toString();
    }

    public static String shapeThreeParameters(String name,
            double parameter1,
            double parameter2,
            double parameter3) throws NegativeValuesException {
        
        JSONObject areaShape = createErrorJSON(name, ERROR_MESSAGE_NOT_THE_GOOD_SHAPE);
        double area;
        
        if (name.toUpperCase().equals("TRAPEZOID")) {
            area = ShapesArea.computeAreaTrapezoid(parameter1,
                    parameter2,
                    parameter3);
            createJSONHeader(areaShape, name);
            areaShape.accumulate("base1", parameter1);
            areaShape.accumulate("base2", parameter2);
            areaShape.accumulate("height", parameter3);
            areaShape.accumulate("area", area);
        }
        return areaShape.toString();
    }

    public static String shapeOneParameter(String name,
            double parameter1) throws NegativeValuesException {
        
        JSONObject areaShape = createErrorJSON(name, ERROR_MESSAGE_NOT_THE_GOOD_SHAPE);
        double area;
        
        if (name.toUpperCase().equals("CIRCLE")) {
            area = ShapesArea.computeAreaCircle(parameter1);
            createJSONHeader(areaShape, name);
            areaShape.accumulate("radius", parameter1);
            areaShape.accumulate("area", area);
        }
        
        if (name.toUpperCase().equals("SQUARE")) {
            area = ShapesArea.computeAreaSquare(parameter1);
            createJSONHeader(areaShape, name);
            areaShape.accumulate("side", parameter1);
            areaShape.accumulate("area", area);
        }
        return areaShape.toString();
    }

    public static String shapeTwoParameters(String name,
            double parameter1,
            double parameter2) throws NegativeValuesException {
        
        JSONObject areaShape = createErrorJSON(name, ERROR_MESSAGE_NOT_THE_GOOD_SHAPE);
        double area;
        
        if (name.toUpperCase().equals("TRIANGLE")) {
            area = ShapesArea.computeAreaTriangle(parameter1, parameter2);
            createJSONHeader(areaShape, name);
            areaShape.accumulate("base", parameter1);
            areaShape.accumulate("height", parameter2);
            areaShape.accumulate("area", area);
        }
        
        if (name.toUpperCase().equals("RECTANGLE")) {
            area = ShapesArea.computeAreaRectangle(parameter1, parameter2);
            createJSONHeader(areaShape, name);
            areaShape.accumulate("width", parameter1);
            areaShape.accumulate("height", parameter2);
            areaShape.accumulate("area", area);
        }
        
        if (name.toUpperCase().equals("PARALLELOGRAM")) {
            area = ShapesArea.computeAreaParallelogram(parameter1, parameter2);
            createJSONHeader(areaShape, name);
            areaShape.accumulate("base", parameter1);
            areaShape.accumulate("height", parameter2);
            areaShape.accumulate("area", area);
        }
        
        if (name.toUpperCase().equals("ELLIPSE")) {
            area = ShapesArea.computeAreaEllipse(parameter1, parameter2);
            createJSONHeader(areaShape, name);
            areaShape.accumulate("major", parameter1);
            areaShape.accumulate("minor", parameter2);
            areaShape.accumulate("area", area);
        }
        
        if (name.toUpperCase().equals("SECTOR")) {
            area = ShapesArea.computeAreaSector(parameter1, parameter2);
            createJSONHeader(areaShape, name);
            areaShape.accumulate("radius", parameter1);
            areaShape.accumulate("angle", parameter2);
            areaShape.accumulate("area", area);
        }
        return areaShape.toString();
    }
    
    public static JSONObject createErrorJSON(String name, String errorMessage) {
        Date date = new Date();
        long unixTimeStamp = date.getTime();
        JSONObject areaShape = new JSONObject();
        
        areaShape.accumulate("Status", "Error");
        areaShape.accumulate("Timestamp", unixTimeStamp);
        areaShape.accumulate("Shape", name.toUpperCase());
        areaShape.accumulate("Message", errorMessage);
        
        return areaShape;
    }
    
    private static void createJSONHeader(JSONObject areaShape, String theName) {
        Date date = new Date();
        long unixTimeStamp = date.getTime();
        
        areaShape.clear();
        areaShape.accumulate("Status", "OK");
        areaShape.accumulate("Timestamp", unixTimeStamp);
        areaShape.accumulate("Shape", theName.toUpperCase());
    }
    
}
