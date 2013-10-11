/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.hibernatejsf.service;

import com.home.hibernatejsf.dao.UserDao;
import com.home.hibernatejsf.model.User;
import com.sun.istack.internal.logging.Logger;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mike
 */
@Service("userService")
public class UserServiceImpl implements UserService, Serializable{
     private static final Logger LOG = Logger.getLogger(UserServiceImpl.class);
    
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;
            
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByName(String userName) {
        return userDao.getUserByName(userName);
    }

    @Override
    public User updateUser(User oldUser) {
        return userDao.updateUser(oldUser);
    }
}
