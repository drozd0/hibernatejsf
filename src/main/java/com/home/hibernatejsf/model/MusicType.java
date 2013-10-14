/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.hibernatejsf.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Mike
 */
@Entity
@Table(schema = "schema1", name = "music_type")
public class MusicType implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "music_type_id")
    private Integer musicTypeId;
    
    @Column(name = "music_type_description", nullable = false)
    private String title;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "musicType")
    private List<Music> musicList;

    /**
     * @return the musicTypeId
     */
    public Integer getMusicTypeId() {
        return musicTypeId;
    }

    /**
     * @param musicTypeId the musicTypeId to set
     */
    public void setMusicTypeId(Integer musicTypeId) {
        this.musicTypeId = musicTypeId;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the musicList
     */
    public List<Music> getMusicList() {
        return musicList;
    }

    /**
     * @param musicList the musicList to set
     */
    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }
    
    @Override
    public String toString(){
    return title;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + (this.musicTypeId != null ? this.musicTypeId.hashCode() : 0);
        hash = 31 * hash + (this.title != null ? this.title.hashCode() : 0);
        hash = 31 * hash + (this.musicList != null ? this.musicList.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MusicType other = (MusicType) obj;
        if ((this.title == null) ? (other.title != null) : !this.title.equals(other.title)) {
            return false;
        }
        return true;
    }
}
