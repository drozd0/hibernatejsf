/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.hibernatejsf.dao;

import com.home.hibernatejsf.model.Music;
import com.home.hibernatejsf.model.User;
import java.util.List;

/**
 *
 * @author Mike
 */
public interface UserDao{
    void saveUser(User user);
    User getUserById(Long id);
    User getUserByName(String userName);
    User updateUser(User oldUser);
}
