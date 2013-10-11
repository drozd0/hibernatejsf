/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.hibernatejsf.service;

import com.home.hibernatejsf.model.User;

/**
 *
 * @author Mike
 */
public interface UserService {
    void saveUser(User user);
    User getUserById(Long id);
    User getUserByName(String userName);
    User updateUser(User oldUser);
}
