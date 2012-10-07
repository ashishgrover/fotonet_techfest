/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nagarro.fotonet.businessfacade.impl;

import com.nagarro.fotonet.businessfacade.AlbumFacade;
import com.nagarro.fotonet.common.SharingStatus;
import com.nagarro.fotonet.entity.Album;
import com.nagarro.fotonet.entity.User;
import com.nagarro.fotonet.exceptions.AlbumSharingStatusException;
import com.nagarro.fotonet.exceptions.ItemNotFoundException;
import com.nagarro.fotonet.services.AlbumService;
import com.nagarro.fotonet.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ashish1813
 */
public class AlbumFacadeImpl implements AlbumFacade{

    @Autowired
    private AlbumService albumService;
    
    @Autowired
    private UserService userService;
    
    public void setAlbumService(AlbumService albumService){
        this.albumService = albumService;
    }

    public void setUserService(UserService userService){
        this.userService = userService;
    }
    
    
    @Override
    public void setSharingStatusForAlbum(Integer albumId, String sharingStatus) 
            throws AlbumSharingStatusException, ItemNotFoundException{
        
        Album album = albumService.getAlbumById(albumId);
        
        if(album.getSharingStatus().equals(SharingStatus.INVALID)){
            throw new AlbumSharingStatusException("Album not published.");
        }else{
            album.setSharingStatus(SharingStatus.valueOf(sharingStatus));
        }
        
    }

    @Override
    public List<Album> getSharedAlbums(Integer userId) throws ItemNotFoundException {
        return albumService.getAlbumsSharedWithUser(userId);
    }

    @Override
    public List<Album> getUserAlbums(Integer userId) {
        User user = userService.getUserById(userId);
        return null;
    }

    @Override
    public List<Album> getPublicAlbumsofUser(Integer userId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setPublishStatus(Integer albumId, Boolean publish) throws ItemNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addAlbumBuddyGroups(Integer albumId, List<Integer> buddyGroupIds) throws ItemNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeAlbumBuddyGroups(Integer albumId, List<Integer> buddyGroupIds) throws ItemNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
