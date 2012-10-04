package com.nagarro.fotonet.services;

import java.util.List;

import com.nagarro.fotonet.entity.Album;

/**
 * @author shalini1814
 * 
 */
public interface AlbumService {

    /**
     * Creates an Album owned by User with {@code userId}
     * and {@code name} provided by them.
     *
     * @param name Album name
     * @param userId ID of User creating it
     */
    void createAlbum(String name, Long userId);

    /**
     * Returns Album with given {@code id}.
     * 
     * @param id ID of the required Album
     * @return Album with {@code id}
     */
    Album getAlbumById(Long id);
    
    /**
     * Gets all Albums owned by User with given {@code userId}
     * @param userId ID of User owning the album
     * @return {@link List} of Album
     */
    List<Album> getAlbumsByUser(Long userId);

    /**
     * Gets Album owned by User with {@code userId}
     * and having {@code name}.
     * @param userId ID of User owning Album
     * @param name Name of required album
     * @return Album
     */
    Album getAlbumByUser(Long userId, String name);


    /**
     * Updates the name of Album with ID {@code id}
     * with {@code name}.
     * @param id ID of Album
     * @param name New name
     */
    void setAlbumName(Long id, String name);

    /**
     * Deletes the Album with given {@code id}.
     * @param id ID of Album to be deleted
     */
    void deleteAlbum(Long id);

    /**
     * Deletes the Album owned by User with {@code userId}
     * and having {@code name}.
     * @param userId ID of owner User
     * @param name Name of Album
     */
    void deleteAlbum(Long userId, String name);
}
