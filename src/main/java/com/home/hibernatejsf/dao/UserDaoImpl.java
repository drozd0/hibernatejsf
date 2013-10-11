/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.hibernatejsf.dao;

import com.home.hibernatejsf.controller.BaseController;
import com.home.hibernatejsf.model.Music;
import com.home.hibernatejsf.model.User;
import java.io.Serializable;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mike
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao, Serializable {
    private static final Logger LOG = Logger.getLogger(UserDaoImpl.class);
    
    @Autowired
    private BaseController baseController;
    
    @Override
    public void saveUser(User user) {
        Session session = baseController.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        //session.flush();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public User getUserById(Long id) {
        Session session = baseController.getSessionFactory().openSession();
        return (User) session.get(User.class, id);
    }

    @Override
    public User getUserByName(String userName) {
        Session session = baseController.getSessionFactory().openSession();
        return (User) session.createQuery("from User where userName = :uName").setParameter("uName", userName).uniqueResult();
        
    }

    @Override
    public User updateUser(User newUser) {
        Session session = baseController.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.merge(newUser);
        //session.update(newUser);
        session.getTransaction().commit();
        session.close();
        return newUser;
    }
}
