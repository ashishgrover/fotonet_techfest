/**
 * 
 */
package com.nagarro.fotonet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author shalini1814
 *
 */
@Entity
@Table(name="effect")
public class MediaEffects extends AbstractEntity {

    @Column(name="name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  
}
