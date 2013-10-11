/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.hibernatejsf.web;

import com.home.hibernatejsf.model.Music;
import com.home.hibernatejsf.model.User;
import com.home.hibernatejsf.service.UserService;
import com.home.hibernatejsf.util.Utils;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;


import org.apache.log4j.Logger;
/**
 *
 * @author Mike
 */
@ManagedBean
public class LoginBean implements Serializable{
    private static final Logger LOG = Logger.getLogger(LoginBean.class);
    private static final String ERROR = "error";
    private static final String SUCCESS = "success";

    private UserService userService;
    
    private String userName;
    private String userPassword;

    /**
     * @return the userName
     */
    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }
    
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword the userPassword to set
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    public String login()
    {
        String response = ERROR;
        LOG.trace(userName);
        if (userName != null && userPassword != null)
        {
            try
            {
                User user = userService.getUserByName(userName.trim());
                LOG.trace(user);
                if (null != user && user.getUserPassword().equals(userPassword.trim())){
                   response = SUCCESS;
                   Utils.setAtributeToSession("userId", user.getUserId());
                }
    
            }catch(Exception e)
            {
                LOG.error(e);
            }
        }
        return response;
    }
    
}
