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
public class NegativeValuesException extends Exception {
    
    public static final String ERROR_MESSAGE_EXCEPTION =
            "You are trying to compute an area using negative values !";
    
    public NegativeValuesException(){
        System.out.println(ERROR_MESSAGE_EXCEPTION);
  } 
   
    
}
