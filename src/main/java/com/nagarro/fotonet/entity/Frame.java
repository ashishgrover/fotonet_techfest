package com.nagarro.fotonet.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ashish1813
 */
@Entity
@Table(name="frame")
public class Frame extends AbstractChangeableEntity {

    @OneToOne
    private Photo photo;

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }
    
}
