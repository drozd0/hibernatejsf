/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.hibernatejsf.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Mike
 */
@Entity
@Table(name = "help_info")
public class Help implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "help_info_id", nullable = false)
    private Long helpId;
    
    @Column(name = "help_info_title")
    private String title;
    
    @Column(name = "help_info_content")
    private String helpContent;

    /**
     * @return the helpId
     */
    public Long getHelpId() {
        return helpId;
    }

    /**
     * @param helpId the helpId to set
     */
    public void setHelpId(Long helpId) {
        this.helpId = helpId;
    }

    /**
     * @return the helpContent
     */
    public String getHelpContent() {
        return helpContent;
    }

    /**
     * @param helpContent the helpContent to set
     */
    public void setHelpContent(String helpContent) {
        this.helpContent = helpContent;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (this.helpId != null ? this.helpId.hashCode() : 0);
        hash = 89 * hash + (this.helpContent != null ? this.helpContent.hashCode() : 0);
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
        final Help other = (Help) obj;
        if ((this.helpContent == null) ? (other.helpContent != null) : !this.helpContent.equals(other.helpContent)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Help{" + "helpId=" + helpId + ", helpContent=" + helpContent + '}';
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
    
}
