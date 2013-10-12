/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.hibernatejsf.web;

import com.home.hibernatejsf.model.Music;
import com.home.hibernatejsf.model.User;
import com.home.hibernatejsf.service.MusicService;
import com.home.hibernatejsf.service.UserService;
import com.home.hibernatejsf.util.SessionAttributes;
import com.home.hibernatejsf.util.Utils;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.apache.log4j.Logger;

/**
 *
 * @author Mike
 */
@ManagedBean
public class PrivateOfficeBean implements Serializable{
    private static final Logger LOG = Logger.getLogger(PrivateOfficeBean.class);
    private UserService userService;
    private MusicService musicService;
    // ***
    private List<Music> musicList;
    private int currentMusicIndex;
    private String currentMusic;
    // prev and next links
    private boolean disabledPrevLink;
    private boolean disabledNextLink;
    private boolean disabledRemoveLink;
    // utils variable
    private static final String PLAY_LIST_EMPTY = "Playlist is empty!";
    private static final String UNEXPECTED_ERROR = "Unexpected error is happened!";
    
    public void setUserService(UserService userService){
        this.userService = userService;
    }
    
    public void setMusicService(MusicService musicService){
        this.musicService = musicService;
    }
    
    @PostConstruct
    public void initData(){
        this.currentMusicIndex = 0;
        getUpdateMusicList();
    }
    
    public void removeCurrentMusic(){
        System.out.println("remove current music!");
        Long currentMusicId = musicList.get(currentMusicIndex).getMusicId();
        Music currentMusicFromDb = musicService.getMusicById(currentMusicId);
        Long currentUserId = (Long) Utils.getAtributeFromSession(SessionAttributes.UserId.getAttributeName());
        User currentUser  = userService.getUserById(currentUserId);
        if(currentUser != null){
            List<Music> userMusicList = currentUser.getListMusic();
            if(userMusicList != null){
                userMusicList.remove(currentMusicFromDb);
                currentUser.setListMusic(userMusicList);
                userService.updateUser(currentUser);
                // need to update data on the page, do not need to fetch data from DB, because we already fetched it.
                musicList = userMusicList;
                updateCurrentMusicAfterRemoving();
            }
        }
    }
    
    private void updateCurrentMusicAfterRemoving(){
        if(currentMusicIndex >= musicList.size()){
            // need to begin again
            currentMusicIndex = 0;
            updateCurrentMusic();
        }else{
            if(musicList != null)
                currentMusic = musicList.get(currentMusicIndex).getMusicContent();
            else
                currentMusic = UNEXPECTED_ERROR;
        }
    }
    
    public void decrementCurrentMusicIndex(){
        System.out.println("decrementCurrentMusicIndex");
        currentMusicIndex--;
        updateCurrentMusic();
    }

            
    public void incrementCurrentMusicIndex(){
        System.out.println("incrementCurrentMusicIndex");
        currentMusicIndex++;
        updateCurrentMusic();
    }

    /**
     * @return the currentMusicIndex
     */
    public int getCurrentMusicIndex() {
        return currentMusicIndex;
    }

    /**
     * @param currentMusicIndex the currentMusicIndex to set
     */
    public void setCurrentMusicIndex(int currentMusicIndex) {
        this.currentMusicIndex = currentMusicIndex;
    }

    /**
     * @return the currentMusic
     */
    public String getCurrentMusic() {
        System.out.println("getCurrentMusic...");
        return currentMusic;
    }

    /**
     * @param currentMusic the currentMusic to set
     */
    public void setCurrentMusic(String currentMusic) {
        this.currentMusic = currentMusic;
    }

    /**
     * @return the disabledPrevLink
     */
    public boolean isDisabledPrevLink() {
       if(currentMusicIndex > 0){
            disabledPrevLink = false;
        }
        else{
            disabledPrevLink = true;
        }
        return disabledPrevLink;
    }

    /**
     * @param disabledPrevLink the disabledPrevLink to set
     */
    public void setDisabledPrevLink(boolean disabledPrevLink) {
        this.disabledPrevLink = disabledPrevLink;
    }

    /**
     * @return the diabledNextLink
     */
    public boolean isDisabledNextLink() {
        if(musicList != null && (currentMusicIndex  < (musicList.size()-1))){
            disabledNextLink = false;
        }
        else{ 
            disabledNextLink = true;
        }
        return disabledNextLink;
    }

    /**
     * @param diabledNextLink the diabledNextLink to set
     */
    public void setDisabledNextLink(boolean diabledNextLink) {
        this.disabledNextLink = diabledNextLink;
    }

    private void updateCurrentMusic() {
        if(musicList != null && !musicList.isEmpty())
            currentMusic = musicList.get(currentMusicIndex).getMusicContent();
        else
            currentMusic = PLAY_LIST_EMPTY;
    }
    
    public boolean getUpdateMusicList(){
        Long currentUserId = (Long) Utils.getAtributeFromSession(SessionAttributes.UserId.getAttributeName());
        User user = userService.getUserById(currentUserId);
        if(user != null){
            musicList = user.getListMusic();
        }
        updateCurrentMusic();
        return true;
    }

    /**
     * @return the disabledRemoveLink
     */
    public boolean isDisabledRemoveLink() {
        if(musicList == null || musicList.isEmpty())
            return true;
        else 
            return false;
    }

    /**
     * @param disabledRemoveLink the disabledRemoveLink to set
     */
    public void setDisabledRemoveLink(boolean disabledRemoveLink) {
        this.disabledRemoveLink = disabledRemoveLink;
    }
}
