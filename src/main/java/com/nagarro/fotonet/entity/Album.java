/**
 * 
 */
package com.nagarro.fotonet.entity;

import com.nagarro.fotonet.common.SharingStatus;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @author shalini1814
 *
 */
@Entity
@Table(name="album")
public class Album extends AbstractChangeableEntity {
    
    @ManyToOne
    @JoinTable(name="user_ownedalbums",
        joinColumns=@JoinColumn(name="album"),
        inverseJoinColumns=@JoinColumn(name="user"))
    private User user;

    @Column(name="album_name")
    private String albumName;
   
    @Version
    private Integer version;

    @Column(name="published")
    private Boolean published;

    @Column(name="sharing_status")
    private SharingStatus sharingStatus;

    @OneToOne
    private Photo coverPhoto;

    @ManyToMany
    @JoinTable(name="album_photos",
        joinColumns=@JoinColumn(name="album"),
        inverseJoinColumns=@JoinColumn(name="photo"))
    private Set<Photo> photos;

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

    public SharingStatus getSharingStatus() {
            return sharingStatus;
    }

    public void setSharingStatus(SharingStatus sharingStatus) {
            this.sharingStatus = sharingStatus;
    }

    public Photo getCoverPhoto(){
        return coverPhoto;
    }

    public void setCoverPhoto(Photo coverPhoto){
        this.coverPhoto = coverPhoto;
    }

    public Set<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<Photo> photos) {
        this.photos = photos;
    }
}
