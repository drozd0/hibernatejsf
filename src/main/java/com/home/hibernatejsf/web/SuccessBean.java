/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.hibernatejsf.web;

import com.home.hibernatejsf.model.User;
import com.home.hibernatejsf.service.UserService;
import com.home.hibernatejsf.util.Utils;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.apache.log4j.Logger;

/**
 *
 * @author Mike
 */
@ManagedBean
public class SuccessBean implements Serializable{
    private static final Logger LOG = Logger.getLogger(SuccessBean.class);
    private UserService userService;
    
    public void setUserService(UserService userService){
        this.userService = userService;
    }
    
    public String getUserName(){
        String result = "Unknown user!";
        Long currentUserId = (Long) Utils.getAtributeFromSession("userId");
        User currentUser = userService.getUserById(currentUserId);
        if (currentUser != null) {
            result = currentUser.getUserName() + "!";
        }
        return result;
    }
    
}
