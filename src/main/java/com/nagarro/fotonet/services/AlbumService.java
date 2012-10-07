package com.nagarro.fotonet.services;

import java.util.List;

import com.nagarro.fotonet.entity.Album;
import com.nagarro.fotonet.exceptions.ItemNotFoundException;
import com.nagarro.fotonet.exceptions.ItemOverwriteException;

/**
 * @author shalini1814
 * 
 */
public interface AlbumService {

    /**
     * Creates an Album.
     *
     * @param album Album to be created
     */
    void createAlbum(Album album)
            throws ItemOverwriteException;

    /**
     * Updates the Album.
     * with {@code name}.
     * @param album Album to be updated
     */
    void updateAlbum(Album album);


    /**
     * Returns Album with given {@code id}.
     * 
     * @param id ID of the required Album
     * @return Album with {@code id}
     */
    Album getAlbumById(Integer id)
            throws ItemNotFoundException;
   
    /**
     * Fetches all the Albums shared with User with ID as {@code userId}.
     * @param userId User to get shared Albums for
     * @return Albums shared
     */
    List<Album> getAlbumsSharedWithUser(Integer userId)
            throws ItemNotFoundException;


    
    
}
