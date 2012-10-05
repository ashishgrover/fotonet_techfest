/**
 * 
 */
package com.nagarro.fotonet.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @author shalini1814
 *
 */
@Entity
@Table(name="tag")
public class Tag extends AbstractEntity {
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
