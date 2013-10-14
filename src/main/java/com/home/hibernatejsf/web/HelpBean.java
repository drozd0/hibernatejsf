/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.hibernatejsf.web;

import com.home.hibernatejsf.dao.UtilDao;
import com.home.hibernatejsf.model.Help;
import com.home.hibernatejsf.service.UtilService;
import com.home.hibernatejsf.util.SessionAttributes;
import com.home.hibernatejsf.util.Utils;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import org.apache.log4j.Logger;

/**
 *
 * @author Mike
 */
@ManagedBean
public class HelpBean implements Serializable{
    private static final Logger LOG = Logger.getLogger(HelpBean.class);
    private static final String UNEXPECTED_ERROR = "Unexpected error is happened!";
    private UtilService utilService;
    
    private Long helpValue;
    
    public void setUtilService(UtilService utilService){
        this.utilService = utilService;
    }
    
    /**
     * @return the helpValue
     */
    public Long getHelpValue() {
        return helpValue;
    }

    /**
     * @param helpValue the helpValue to set
     */
    public void setHelpValue(Long helpValue) {
        this.helpValue = helpValue;
    }
    
    public Map<String, Long> getHelpValueMap(){
        Map<String, Long> result = new LinkedHashMap<String, Long>();
        for (Help hlp : utilService.getAllHelp())
        {
            result.put(hlp.getTitle(), hlp.getHelpId());
        }
        return result;
    }
    
    public String getHelpInformation(){
        String result = "";
        if(null != helpValue){
            Help hlp = utilService.getHelpById(helpValue);
            if(hlp != null)
                result = hlp.getHelpContent();
            else
                result = UNEXPECTED_ERROR;
        }
        return result;
    }
    
        public String signOut(){
        LOG.info("SignOut...");
        Utils.removeAtributeFromSession(SessionAttributes.UserId.getAttributeName());
        return "signOut";
    }
}
