package com.nagarro.fotonet.entity;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * This entity stores user information.
 * @author NSPL
 *
 */
@Entity
@Table(name="user")
public class User extends AbstractChangeableEntity {
    
    @Version
    private Integer version;
    
    @Column(name="user_name")
    private String userName;
    
    @Column(name="subscription_id")
    private Integer subscriptionId;

    @Column(name="user_role")
    private String userRole;

    @OneToMany
    @JoinTable(name="user_buddygroups",
        joinColumns=@JoinColumn(name="user"),
        inverseJoinColumns=@JoinColumn(name="group"))
    private Set<BuddyGroup> buddyGroups;

    @OneToMany
    @JoinTable(name="user_ownedalbums",
        joinColumns=@JoinColumn(name="user"),
        inverseJoinColumns=@JoinColumn(name="album"))
    private Set<Album> ownedAlbums;

    public User() {}
    
    public User(String userName) {
        this.userName = userName;
    }
    
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getUserRole() {
            return userRole;
    }

    public void setUserRole(String userRole) {
            this.userRole = userRole;
    }

    public Set<BuddyGroup> getBuddyGroups() {
            return buddyGroups;
    }

    public void setBuddyGroups(Set<BuddyGroup> buddyGroups) {
            this.buddyGroups = buddyGroups;
    }

    public Set<Album> getOwnedAlbums() {
            return ownedAlbums;
    }

    public void setOwnedAlbums(Set<Album> ownedAlbums) {
            this.ownedAlbums = ownedAlbums;
    }
    
}

