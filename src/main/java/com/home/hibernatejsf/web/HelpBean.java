/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.hibernatejsf.web;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.log4j.Logger;

/**
 *
 * @author Mike
 */
@ManagedBean
//@SessionScoped
public class HelpBean implements Serializable{
    private static final Logger LOG = Logger.getLogger(HelpBean.class);
    private Integer helpValue;

    /**
     * @return the helpValue
     */
    public Integer getHelpValue() {
        return helpValue;
    }

    /**
     * @param helpValue the helpValue to set
     */
    public void setHelpValue(Integer helpValue) {
        this.helpValue = helpValue;
    }
    
    public Map<String, Integer> getHelpValueMap(){
        Map<String, Integer> result = new LinkedHashMap<String, Integer>();
        // TODO: get these information from database
        result.put("Possibilities", 1);
        result.put("Cost", 2);
        return result;
    }
    
    public String getHelpInformation(){
        if(null == helpValue){
              return "";
        }
        else if(1 == helpValue)
            return "Service allows to listen and buy a content!";
        else 
            return "Each content costs 100$:)";
    }
    
}
