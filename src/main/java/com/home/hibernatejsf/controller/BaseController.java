/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.hibernatejsf.controller;

import org.hibernate.SessionFactory;

/**
 *
 * @author Mike
 */
public interface BaseController {
    SessionFactory getSessionFactory();
    void setSessionFactory(SessionFactory sessionFactory);
}
