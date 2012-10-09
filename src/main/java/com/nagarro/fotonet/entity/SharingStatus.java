/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nagarro.fotonet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author ashish1813
 */
@Entity
@Table(name="sharingstatus")
public class SharingStatus extends AbstractChangeableEntity{

    @Column(name="status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
