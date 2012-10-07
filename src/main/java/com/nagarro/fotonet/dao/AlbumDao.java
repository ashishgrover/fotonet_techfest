/**
 * 
 */
package com.nagarro.fotonet.dao;

import java.util.List;

import com.nagarro.fotonet.entity.Album;

/**
 * @author shalini1814
 *
 */
public interface AlbumDao extends GenericDao<Album, Integer> {

    
    /**
     * Fetches all the Albums shared with User with ID as {@code userId}.
     * @param userId User to get shared Albums for
     * @return Albums shared
     */
    List<Album> getAlbumsSharedWithUser(Integer userId);

}
