/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.hibernatejsf.service;

import com.home.hibernatejsf.dao.MusicDao;
import com.home.hibernatejsf.model.Music;
import com.home.hibernatejsf.model.MusicType;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mike
 */
@Service("musicService")
public class MusicServiceImpl implements MusicService{
    private static final Logger LOG = Logger.getLogger(MusicServiceImpl.class);
    
    @Autowired
    @Qualifier("musicDao")
    private MusicDao musicDao;

    @Override
    public List<Music> getMusicListByMusicType(MusicType mt) {
        return musicDao.getMusicListByMusicType(mt);
    }

    @Override
    public Music getMusicById(Long id) {
        return musicDao.getMusicById(id);
    }
    
}
