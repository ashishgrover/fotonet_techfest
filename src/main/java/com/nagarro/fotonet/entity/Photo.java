/**
 * 
 */
package com.nagarro.fotonet.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.web.multipart.commons.CommonsMultipartFile;


/**
 * @author shalini1814
 *
 */
@Entity
@Table(name="photo")
public class Photo extends AbstractChangeableEntity {

    
    @Column(name="photo_name")
    private String photoName;
    
    @Column(name="path")
    private String path;

    @Version
    private Integer version;
    
    private Boolean commentsAllowed;

    @ManyToMany
    @JoinTable(name="album_photos",
        joinColumns=@JoinColumn(name="photo"),
        inverseJoinColumns=@JoinColumn(name="album"))
    private List<Album> albums;

    @ManyToMany
    @JoinTable(name="photo_tag",
        joinColumns=@JoinColumn(name="photo"),
        inverseJoinColumns=@JoinColumn(name="tag"))
    private Set<Tag> tags;

    @OneToMany
    @JoinTable(name="photo_comment",
        joinColumns=@JoinColumn(name="photo"),
        inverseJoinColumns=@JoinColumn(name="comment"))
    private Set<Comment> comments;
    
    private transient CommonsMultipartFile fileData;

    
    public Photo() {}
    
    public Photo(String photoName, User uploader, Date createdOn) {
        this.photoName = photoName;
        this.createdOn = createdOn;
    }
    
    public Photo(String photoName, User uploader, String path, Integer version, Date createdOn) {
        this.photoName = photoName;
        this.path = path;
        this.version = version;
        this.createdOn = createdOn;
    }
    
    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public CommonsMultipartFile getFileData() {
            return fileData;
    }

    public void setFileData(CommonsMultipartFile fileData) {
            this.fileData = fileData;
    }

    public Boolean getCommentsAllowed() {
            return commentsAllowed;
    }

    public void setCommentsAllowed(Boolean commentsAllowed) {
            this.commentsAllowed = commentsAllowed;
    }

    public Set<Tag> getTags() {
            return tags;
    }

    public void setTags(Set<Tag> tags) {
            this.tags = tags;
    }

    public Set<Comment> getComments() {
            return comments;
    }

    public void setComments(Set<Comment> comments) {
            this.comments = comments;
    }

}
