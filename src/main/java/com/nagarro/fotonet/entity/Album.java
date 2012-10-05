/**
 * 
 */
package com.nagarro.fotonet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @author shalini1814
 *
 */
@Entity
@Table(name="album")
public class Album extends AbstractChangeableEntity {

    @Column(name="album_name")
    private String albumName;
    
    @ManyToOne
    private User uploader;
    
    @Version
    private Integer version;
    
    private Boolean published;
    
    private String sharingStatus;
    
    private Boolean commentsAllowed;
    
    public User getUploader() {
        return uploader;
    }

    public void setUploader(User uploader) {
        this.uploader = uploader;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
    
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean isPublished() {
            return published;
    }

    public void setPublished(Boolean published) {
            this.published = published;
    }

    public String getSharingStatus() {
            return sharingStatus;
    }

    public void setSharingStatus(String sharingStatus) {
            this.sharingStatus = sharingStatus;
    }

    public Boolean isCommentsAllowed() {
            return commentsAllowed;
    }

    public void setCommentsAllowed(Boolean commentsAllowed) {
            this.commentsAllowed = commentsAllowed;
    }

  
}
