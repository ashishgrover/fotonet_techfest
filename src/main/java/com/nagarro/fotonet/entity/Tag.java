/**
 * 
 */
package com.nagarro.fotonet.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @author shalini1814
 *
 */
@Entity
@Table(name="tag")
public class Tag extends AbstractChangeableEntity {
    
    @ManyToMany
    @JoinTable(name="photo_tag",
        joinColumns=@JoinColumn(name="tag"),
        inverseJoinColumns=@JoinColumn(name="photo"))
    private Photo photo;

    @Version
    private Integer version;
    
    private String content;

    public String getContent() {
            return content;
    }

    public void setContent(String content) {
            this.content = content;
    }
}
