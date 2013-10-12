/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.hibernatejsf.dao;

import com.home.hibernatejsf.controller.BaseController;
import com.home.hibernatejsf.model.Music;
import com.home.hibernatejsf.model.MusicType;
import java.util.ArrayList;
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
@Repository("musicDao")
public class MusicDaoImpl implements MusicDao{
    private static final Logger LOG = Logger.getLogger(MusicDaoImpl.class);
    
    @Autowired
    @Qualifier("baseController")
    private BaseController baseController;

    @Override
    public List<Music> getMusicListByMusicType(MusicType mt) {
        LOG.trace("Into getMusicListByMusicType(" + mt + ")");
        Session session = baseController.getSessionFactory().openSession();
        List<Music> result = new ArrayList<Music>();
        try{
            result = session.createQuery("from Music m where m.musicType = :mt").setParameter("mt", mt).list();
        }catch(Exception e){
            LOG.error(e);
        }finally{
            session.close();
            LOG.trace("Exit getMusicListByMusicType(" + mt + ")");
            return result;
        }
    }

    @Override
    public Music getMusicById(Long id) {
        LOG.trace("Into getMusicById(" + id + ")");
        Session session = baseController.getSessionFactory().openSession();
        return (Music) session.get(Music.class, id);
    }
    
}
