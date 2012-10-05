/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nagarro.fotonet.businessfacade.impl;

import com.nagarro.fotonet.businessfacade.AlbumFacade;
import com.nagarro.fotonet.common.SharingStatus;
import com.nagarro.fotonet.entity.Album;
import com.nagarro.fotonet.exceptions.AlbumSharingStatusException;
import com.nagarro.fotonet.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ashish1813
 */
public class AlbumFacadeImpl implements AlbumFacade{

    @Autowired
    private AlbumService albumService;
    
    public void setAlbumService(AlbumService albumService){
        this.albumService = albumService;
    }
    
    
    @Override
    public void setSharingStatusForAlbum(Integer albumId, String sharingStatus) 
            throws AlbumSharingStatusException {
        
        Album album = albumService.getAlbumById(albumId);
        
        if(album.getSharingStatus().equals(SharingStatus.INVALID.toString())){
            throw new AlbumSharingStatusException("Album not published.");
        }else{
//            album.setSharingStatus(sharingStatus);
        }
        
    }
    
}
