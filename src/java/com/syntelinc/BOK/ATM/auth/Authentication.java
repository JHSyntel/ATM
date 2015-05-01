/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syntelinc.BOK.ATM.auth;

/**
 *
 * @author JH5024430
 */
public class Authentication {
    
    public static boolean pinIsCorrect(int pinNumber) {
        return !"55555".equals(Integer.toString(pinNumber));
    }
    
    public static boolean pinFieldsAreEqual(int pin1, int pin2) {
        return pin1 == pin2;
    }
    
    public static boolean validPin(int pin) {
        return (pin > 9999 && pin < 100000);
    }
    
    public static boolean validID(int id) {
        return (id == 55555);
    }
    
    public static boolean sessionActive(boolean authed) { 
        return authed;
    }
}
