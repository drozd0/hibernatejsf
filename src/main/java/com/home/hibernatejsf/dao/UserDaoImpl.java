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
        LOG.trace("Into saveUser(" + user + ")");
        Session session = baseController.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }catch(Exception e){
            LOG.error(e);
        }finally{
            session.close();
             LOG.trace("Exit saveUser(" + user + ")");
        }
        
        
    }

    @Override
    public User getUserById(Long id) {
        LOG.trace("Into getUserById(" + id + ")");
        Session session = baseController.getSessionFactory().openSession();
        return (User) session.get(User.class, id);
    }

    @Override
    public User getUserByName(String userName) {
        LOG.trace("Into getUserByName(" + userName + ")");
        Session session = baseController.getSessionFactory().openSession();
        return (User) session.createQuery("from User where userName = :uName").setParameter("uName", userName).uniqueResult();
        
    }

    @Override
    public User updateUser(User newUser) {
        LOG.trace("Into updateUser(" + newUser + ")");
        Session session = baseController.getSessionFactory().openSession();
        try{
            session.getTransaction().begin();
            session.merge(newUser);
            session.getTransaction().commit();
        }catch(Exception e){
            LOG.error(e);
        }finally{
            session.close();
            LOG.trace("Exit updateUser(" + newUser + ")");
            return newUser;
        }
        
    }
}
