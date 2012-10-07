package com.nagarro.fotonet.entity;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ashish1813
 */
@Entity
@Table(name="buddy_group")
public class BuddyGroup extends AbstractChangeableEntity{

    @Column(name="group_name")
    private String groupName;

    private Set<User> buddies;

    private Set<Album> sharedAlbums;
    
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Set<User> getBuddies() {
        return buddies;
    }

    public void setBuddies(Set<User> buddies) {
        this.buddies = buddies;
    }

    public Set<Album> getSharedAlbums() {
        return sharedAlbums;
    }

    public void setSharedAlbums(Set<Album> sharedAlbums) {
        this.sharedAlbums = sharedAlbums;
    }

}
