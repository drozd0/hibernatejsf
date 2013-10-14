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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Mike
 */
@Entity
@Table(schema = "schema1", name = "music")
public class Music implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "music_id", nullable = false, unique = true)
    private Long musicId;
    
    @Column(name = "music_content")
    private String musicContent;
    
    @Column(name = "music_cost")
    private Integer musicCost;
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "listMusic")
    @Cascade(CascadeType.ALL)
    private List<User> listUsers;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "music_type", nullable = false)
    private MusicType musicType;

    /**
     * @return the musicId
     */
    public Long getMusicId() {
        return musicId;
    }

    /**
     * @param musicId the musicId to set
     */
    public void setMusicId(Long musicId) {
        this.musicId = musicId;
    }

    /**
     * @return the musicContent
     */
    public String getMusicContent() {
        return musicContent;
    }

    /**
     * @param musicContent the musicContent to set
     */
    public void setMusicContent(String musicContent) {
        this.musicContent = musicContent;
    }

    /**
     * @return the musicCost
     */
    public Integer getMusicCost() {
        return musicCost;
    }

    /**
     * @param musicCost the musicCost to set
     */
    public void setMusicCost(Integer musicCost) {
        this.musicCost = musicCost;
    }

    /**
     * @return the listUsers
     */
    public List<User> getListUsers() {
        return listUsers;
    }

    /**
     * @param listUsers the listUsers to set
     */
    public void setListUsers(List<User> listUsers) {
        this.listUsers = listUsers;
    }

    /**
     * @return the musicType
     */
    public MusicType getMusicType() {
        return musicType;
    }

    /**
     * @param musicType the musicType to set
     */
    public void setMusicType(MusicType musicType) {
        this.musicType = musicType;
    }
    
    @Override
    public String toString() {
        return "Music{" + "musicContent=" + musicContent + ", musicCost=" + musicCost + ", musicType=" + musicType + '}';
    }
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (this.musicContent != null ? this.musicContent.hashCode() : 0);
        hash = 67 * hash + (this.musicCost != null ? this.musicCost.hashCode() : 0);
        hash = 67 * hash + (this.musicType != null ? this.musicType.hashCode() : 0);
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
        final Music other = (Music) obj;
        if ((this.musicContent == null) ? (other.musicContent != null) : !this.musicContent.equals(other.musicContent)) {
            return false;
        }
        if (this.musicType != other.musicType && (this.musicType == null || !this.musicType.equals(other.musicType))) {
            return false;
        }
        return true;
    }
}
