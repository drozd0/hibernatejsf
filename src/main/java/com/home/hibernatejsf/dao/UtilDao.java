/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.hibernatejsf.dao;

import com.home.hibernatejsf.model.Help;
import com.home.hibernatejsf.model.MusicType;
import java.util.List;

/**
 *
 * @author Mike
 */
public interface UtilDao {
    List<MusicType> getAllMusicTypes();
    MusicType getMusicTypeById(Integer id);
    List<Help> getAllHelp();
    Help getHelpById(Long id);
}
