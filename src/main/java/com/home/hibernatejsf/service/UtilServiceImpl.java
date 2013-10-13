/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.hibernatejsf.service;

import com.home.hibernatejsf.dao.UtilDao;
import com.home.hibernatejsf.model.Help;
import com.home.hibernatejsf.model.MusicType;
import com.home.hibernatejsf.web.HelpBean;
import java.io.Serializable;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mike
 */
@Service("utilService")
public class UtilServiceImpl implements UtilService{
    @Autowired
    @Qualifier("utilDao")
    private UtilDao utilDao;

    @Override
    public List<MusicType> getAllMusicTypes() {
        return utilDao.getAllMusicTypes();
    }

    @Override
    public MusicType getMusicTypeById(Integer id) {
        return utilDao.getMusicTypeById(id);
    }

    @Override
    public List<Help> getAllHelp() {
        return utilDao.getAllHelp();
    }

    @Override
    public Help getHelpById(Long id) {
        return utilDao.getHelpById(id);
    }
    
}
