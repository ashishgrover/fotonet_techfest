/**
 * 
 */
package com.nagarro.fotonet.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    
    @Column(name="physical_path")
    private String physicalPath;

    @Version
    private Integer version;
    
    @Column(name="comments_allowed")
    private Boolean commentsAllowed;

    @OneToMany(mappedBy="pk.photo")
    private Set<AlbumPhoto> albumPhoto;

    @ManyToMany
    @JoinTable(name="photo_tags",
        joinColumns=@JoinColumn(name="photoid"),
        inverseJoinColumns=@JoinColumn(name="tagid"))
    private Set<Tag> tags;

    @OneToMany
    @JoinTable(name="photo_comments",
        joinColumns=@JoinColumn(name="photoid"),
        inverseJoinColumns=@JoinColumn(name="commentid"))
    private Set<Comment> comments;
    
    @Column(name="effect_params")
    private HashMap<String, String> effectParams;
    
    private transient CommonsMultipartFile fileData;

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getPhysicalPath() {
		return physicalPath;
	}

	public void setPhysicalPath(String physicalPath) {
		this.physicalPath = physicalPath;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
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

	public CommonsMultipartFile getFileData() {
		return fileData;
	}

	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}

        public Set<AlbumPhoto> getAlbumPhoto() {
            return albumPhoto;
        }

        public void setAlbumPhoto(Set<AlbumPhoto> albumPhoto) {
            this.albumPhoto = albumPhoto;
        }
        
        public Map<String, String> getEffectParams() {
            return effectParams;
        }

        public void setEffectParams(HashMap<String, String> effectParams) {
            this.effectParams = effectParams;
        }
        
        

  
}
