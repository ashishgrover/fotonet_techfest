/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nagarro.fotonet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author ashish1813
 */
@Entity
public class UserRole extends AbstractChangeableEntity {
    
    @Column(name="roel_name")
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    
}
