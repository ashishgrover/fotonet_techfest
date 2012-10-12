package com.nagarro.fotonet.dao;


import com.nagarro.fotonet.entity.Album;
import java.util.Collection;

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
    Collection<Album> getAlbumsSharedWithUser(Integer userId);
    
    /**
     * Fetches all the Albums owned by User with ID as {@code ownerId}.
     * @param ownerId User to get public albums of
     * @return Public Albums owned
     */
    Collection<Album> getPublicAlbumsOfUser(Integer ownerId);

}
