/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nagarro.fotonet.businessfacade;

import com.nagarro.fotonet.entity.Album;
import com.nagarro.fotonet.exceptions.AlbumSharingStatusException;
import com.nagarro.fotonet.exceptions.ItemNotFoundException;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author ashish1813
 */
public interface AlbumFacade {
    
    /**
     * Changes the sharing settings for album with ID as {@code albumId}
     * to {@code sharingStatus}.
     *
     * @param albumId ID of album to change status for
     * @param sharingStatus Resulting status
     * @throws AlbumSharingStatusException If the Album is unpublished and
     * an attempt is made to set it's status, this exception is thrown.
     */
    void setSharingStatusForAlbum(Integer albumId, String sharingStatus)
            throws AlbumSharingStatusException, ItemNotFoundException;

    /**
     * Publishes or unpublishes an Album.
     *
     * @param albumId ID of album to be published or unpublished
     */
    void setPublishStatus(Integer albumId, Boolean publish)
            throws ItemNotFoundException;

    /**
     * Adds BuddyGroup ID(s) for Album with ID as {@code albumId}.
     *
     * @param albumId ID of Album
     * @param buddyGroupIds ID of Buddy groups to share album with
     */
    void addAlbumBuddyGroups(Integer albumId, List<Integer> buddyGroupIds)
            throws ItemNotFoundException;

    /**
     * Removes BuddyGroup ID(s) for Album with ID as {@code albumId}.
     *
     * @param albumId ID of Album
     * @param buddyGroupIds ID of Buddy groups to stop sharing album with
     */
    void removeAlbumBuddyGroups(Integer albumId, List<Integer> buddyGroupIds)
            throws ItemNotFoundException;

    /**
     * Gets all the albums shared with User with ID as {@code userId}.
     * User is not the owner of any of the Albums returned.
     *
     * @param userId
     * @return List of albums shared with User
     */
    Collection<Album> getSharedAlbums(Integer userId)
            throws ItemNotFoundException;

    /**
     * Gets all the albums owned User with ID as {@code userId}.
     *
     * @param userId
     * @return List of albums shared with User
     */
    Collection<Album> getUserAlbums(Integer userId)
            throws ItemNotFoundException;

    /**
     * Gets Albums of User with {@code  userId} which are publically
     * shared.
     *
     * @param userId ID of User
     * @return Public albums of User
     */
    Collection<Album> getPublicAlbumsofUser(Integer userId)
            throws ItemNotFoundException;


}
