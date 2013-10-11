/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.hibernatejsf.util;

/**
 *
 * @author Mike
 */
public enum SessionAttributes {
    UserId("userId");
    
    private String attributeName;
    
    private SessionAttributes(String arg){
        attributeName = arg;
    }
    
    public String getAttributeName(){
        return this.attributeName;
    }
}
