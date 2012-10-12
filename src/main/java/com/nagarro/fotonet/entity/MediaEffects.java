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
@Table(name="effects")
public class MediaEffects extends AbstractEntity {

    @Column(name="name")
    private String name;
    
    @Column(name="method")
    private String methodName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
    
    
    
}
