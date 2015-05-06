/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syntelinc.BOK.ATM.auth;

import com.opensymphony.xwork2.ActionContext;
import com.syntelinc.BOK.ATM.menupkg.Hibernate;
import java.util.Map;

/**
 *
 * @author JH5024430
 */
public class Authentication{
    
    public static boolean pinIsCorrect(String userID, int pinNumber) {
        Hibernate h = new Hibernate();
        return h.comparePinForUser(Integer.valueOf(userID), pinNumber);
    }
    
    public static Map<String, Object> getSession() {
        return ActionContext.getContext().getSession();
    }
    
    public static boolean pinFieldsAreEqual(int pin1, int pin2) {
        return pin1 == pin2;
    }
    
    public static boolean validPin(int pin) {
        return (pin > 9999 && pin < 100000);
    }
    
    public static boolean userExists(String userID) {
        Hibernate h = new Hibernate();
        return h.userExists(Integer.valueOf(userID));
    }
    
    public static boolean validID(String userID) {
        return (Integer.valueOf(userID) > 9999 && Integer.valueOf(userID) < 100000);
    }
    
    public static boolean sessionActiveCheck() {
        Map<String, Object> userSession = Authentication.getSession();
        System.out.println("Authenticated: " + userSession.get("authenticated"));
        if(userSession.get("authenticated") == null) {
            userSession.put("authenticated", Boolean.FALSE);
            return true;
        }
        if(userSession.isEmpty()) {
            System.out.println("User Session Empty");
            return false;
        }
        System.out.println("Authenticated: " + userSession.get("authenticated"));
        
        //If session not found base case
        return false;
    }
    
    public static void storeUserID(String userID) {
        Map<String, Object> userSession = Authentication.getSession();
        userSession.put("userid", userID);
        System.out.println("**********1******** userID is " + userID + ", userSession.get(userID) is " + (String) userSession.get("userid)"));
    }
    
    public static String getUserIDfromSession() {
        return (String) Authentication.getSession().get("userid");
    }
    
    /**
     *
     * @return an int value describing the auth status. Returns -1 if no session exists, 0 if not authorized, and 1 if authorized. Returns -2 for any other cases.
     */
    public static int authCheck() {
    Map<String, Object> userSession = Authentication.getSession();
    System.out.println("Authenticated: " + (Boolean) userSession.get("authenticated"));
    Boolean b = (Boolean) userSession.get("authenticated");
    if(b == null)
        //<jsp:forward page="/Views/Auth/NoSession.jsp"/> 
        return -1;
    else if( b.equals(Boolean.FALSE))
        //<jsp:forward page="/Views/Auth/NotAuthorized.jsp"/>   
        return 0;
    else if( b.equals(Boolean.TRUE))
        return 3;
    else
        return -2;
    }
}
