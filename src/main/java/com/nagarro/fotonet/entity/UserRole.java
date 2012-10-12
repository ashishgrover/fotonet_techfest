/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nagarro.fotonet.entity;

import java.util.HashMap;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author ashish1813
 */
@Entity
public class UserRole extends AbstractChangeableEntity {
    
    @Column(name="role_name")
    private String roleName;
    
    @Column(name="quotas")
    private HashMap<String, String> quotas;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public HashMap<String, String> getQuotas() {
        return quotas;
    }

    public void setQuotas(HashMap<String, String> quotas) {
        this.quotas = quotas;
    }
    
    
    
    
}
