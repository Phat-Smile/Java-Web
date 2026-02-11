/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author ACER
 */
public class Validation {

    public final static String PHONE ="^(03|05|07|08|09)\\d{8}$";
    
    public static boolean isValid(String data, String regex) {
        return data.matches(regex);
    }
}
