/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.hibernatejsf.dao;

import com.home.hibernatejsf.controller.BaseController;
import com.home.hibernatejsf.model.Help;
import com.home.hibernatejsf.model.MusicType;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mike
 */
@Repository("utilDao")
public class UtilDaoImpl implements UtilDao{
    private static final Logger LOG = Logger.getLogger(UtilDaoImpl.class);
    
    @Autowired
    @Qualifier("baseController")
    private BaseController baseController;
    
    @Override
    public List<MusicType> getAllMusicTypes() {
        LOG.trace("Into getAllMusicTypes");
        List<MusicType> result = new LinkedList<MusicType>();
        Session session = baseController.getSessionFactory().openSession();
        try {
        result  = session.createQuery("from MusicType").list();
        }catch(Exception e){
            LOG.error(e);
        }finally{
            session.close();
            return result;
        }
    }

    @Override
    public MusicType getMusicTypeById(Integer id) {
        LOG.trace("Into getMusicTypeById("+id+")");
        Session session = baseController.getSessionFactory().openSession();
        return (MusicType)session.get(MusicType.class, id);
    }

    @Override
    public List<Help> getAllHelp() {
        LOG.trace("Into getAllHelp");
        List<Help> result = new LinkedList<Help>();
        Session session = baseController.getSessionFactory().openSession();
        try {
        result  = session.createQuery("from Help").list();
        }catch(Exception e){
            LOG.error(e);
        }finally{
            session.close();
            return result;
        }
    }

    @Override
    public Help getHelpById(Long id) {
        LOG.trace("Into getHelpById("+id+")");
        Session session = baseController.getSessionFactory().openSession();
        return (Help)session.get(Help.class, id);
    }
    
}
