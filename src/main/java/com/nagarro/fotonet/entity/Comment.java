/**
 * 
 */
package com.nagarro.fotonet.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @author shalini1814
 *
 */
@Entity
@Table(name="comment")
public class Comment extends AbstractChangeableEntity {
    
    @ManyToOne
    @JoinTable(name="photo_comment",
        joinColumns=@JoinColumn(name="comment"),
        inverseJoinColumns=@JoinColumn(name="photo"))
    private Photo photo;

    @Version
    private Integer version;
    
    private String comment;

    public Integer getVersion() {
        return version;
    }
    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
}
