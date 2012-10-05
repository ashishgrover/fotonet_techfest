/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nagarro.fotonet.businessfacade;

import com.nagarro.fotonet.exceptions.AlbumSharingStatusException;

/**
 *
 * @author ashish1813
 */
public interface AlbumFacade {
    
    /**
     * Changes the sharing settings for album with ID as {@code albumId}
     * to {@code sharingStatus}.
     * @param albumId ID of album to change status for
     * @param sharingStatus Resulting status
     */
    void setSharingStatusForAlbum(Integer albumId, String sharingStatus) 
            throws AlbumSharingStatusException ;
    
}
