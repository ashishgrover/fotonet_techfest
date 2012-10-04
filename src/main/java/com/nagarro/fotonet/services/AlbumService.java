/**
 * 
 */
package com.nagarro.fotonet.services;

import java.util.List;

import com.nagarro.fotonet.entity.Album;

/**
 * @author shalini1814
 * 
 */
public interface AlbumService {

    /**
     * This API returns album having the received id
     * @param id
     * @return
     */
    Album getAlbumById(int id);
    
    /**
     * 
     * @param userName
     * @return
     */
    List<Album> getAlbumsByUploader(int userId);


    /**
     * Creates an album for the user with
     * name provided by them.
     *
     * @param name Album name
     * @param userId ID of user creating it
     */
    void createAlbum(String name, Long userId);

}
