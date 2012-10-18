package com.nagarro.fotonet.services;

import com.nagarro.fotonet.entity.Album;
import com.nagarro.fotonet.entity.Photo;
import com.nagarro.fotonet.exceptions.AlbumSharingStatusException;
import com.nagarro.fotonet.exceptions.ItemNotFoundException;
import java.util.Collection;

/**
 * @author shalini1814
 * 
 */
public interface AlbumService {
    
    /**
     * Adds a Photo to an Album.
     * 
     * @param albumId ID of Album to add photo to
     * @param photos Photos to be added
     * @return Updated Album
     */
    Album addPhotoToAlbum(Integer albumId, Collection<Photo> photos);
    
    /**
     * Removes a Photo from the Album
     * 
     * @param albumId ID of Album to remove from
     * @param photoId ID of Photo to be removed
     * @return Updated Album
     */
    Album removePhotoFromAlbum(Integer albumId, Integer photoId);

    /**
     * Changes the sharing settings for album with ID as {@code albumId}
     * to {@code sharingStatus}.
     *
     * @param albumId ID of album to change status for
     * @param sharingStatus Resulting status
     * @throws AlbumSharingStatusException If the Album is unpublished and
     * an attempt is made to set it's status, this exception is thrown.
     */
    Album setSharingStatusForAlbum(Integer albumId, String sharingStatus)
            throws AlbumSharingStatusException, ItemNotFoundException;

    /**
     * Publishes or unpublishes an Album.
     *
     * @param albumId ID of album to be published or unpublished
     */
    Album setPublishStatus(Integer albumId, Boolean publish)
            throws ItemNotFoundException;

    /**
     * Adds BuddyGroup ID(s) for Album with ID as {@code albumId}.
     *
     * @param albumId ID of Album
     * @param buddyGroupIds ID of Buddy groups to share album with
     */
    Album addAlbumBuddyGroups(Integer albumId, Collection<Integer> buddyGroupIds)
            throws ItemNotFoundException;

    /**
     * Removes BuddyGroup ID(s) for Album with ID as {@code albumId}.
     *
     * @param albumId ID of Album
     * @param buddyGroupIds ID of Buddy groups to stop sharing album with
     */
    Album removeAlbumBuddyGroups(Integer albumId, Collection<Integer> buddyGroupIds)
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
    
    
    /**
     * Updates the album
     * 
     * @param album 
     * @return Updated album
     */
    Album updateAlbum(Album album);
    
}
