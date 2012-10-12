package com.nagarro.fotonet.services.impl;

import static com.nagarro.fotonet.common.Constants.*;
import com.nagarro.fotonet.dao.AlbumDao;
import com.nagarro.fotonet.dao.BuddyGroupDao;
import com.nagarro.fotonet.dao.UserDao;
import com.nagarro.fotonet.entity.Album;
import com.nagarro.fotonet.entity.User;
import com.nagarro.fotonet.exceptions.AlbumSharingStatusException;
import com.nagarro.fotonet.exceptions.ItemNotFoundException;
import com.nagarro.fotonet.services.AlbumService;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author shalini1814
 */
@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumDao albumDao;

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private BuddyGroupDao buddyGroupDao;

    public void setAlbumDao(AlbumDao albumDao) {
        this.albumDao = albumDao;
    }

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    public void setBuddyGroupDao(BuddyGroupDao buddyGroupDao) {
        this.buddyGroupDao = buddyGroupDao;
    }
    

    @Override
    public Album setSharingStatusForAlbum(Integer albumId, String sharingStatus) 
            throws AlbumSharingStatusException, ItemNotFoundException{
        
        Album album = albumDao.findById(albumId);
        
        if(album.getSharingStatus().getStatus().equals(STATUS_INVALID)){
            throw new AlbumSharingStatusException("Album not published.");
        }else{
            album.getSharingStatus().setStatus(sharingStatus);
            return albumDao.makePersistent(album,true);
        }
    }

    @Override
    public Collection<Album> getSharedAlbums(Integer userId) throws ItemNotFoundException {
        return albumDao.getAlbumsSharedWithUser(userId);
    }

    @Override
    public Collection<Album> getUserAlbums(Integer userId) {
        User user = userDao.findById(userId);
        return user.getOwnedAlbums();
    }

    @Override
    public Collection<Album> getPublicAlbumsofUser(Integer userId) {
        return albumDao.getPublicAlbumsOfUser(userId);
    }

    @Override
    public Album setPublishStatus(Integer albumId, Boolean publish) throws ItemNotFoundException {
        Album album = albumDao.findById(albumId);
        album.setPublished(publish);
        return albumDao.makePersistent(album,true);
    }

    @Override
    public Album addAlbumBuddyGroups(Integer albumId, List<Integer> buddyGroupIds) throws ItemNotFoundException {
        Album album = albumDao.findById(albumId);
        for (Integer id : buddyGroupIds) {
            album.getSharedWithGroup().add(buddyGroupDao.findById(id));
        }
        return albumDao.makePersistent(album, true);
    }

    @Override
    public Album removeAlbumBuddyGroups(Integer albumId, List<Integer> buddyGroupIds) throws ItemNotFoundException {
        Album album = albumDao.findById(albumId);
        for (Integer id : buddyGroupIds) {
            album.getSharedWithGroup().remove(buddyGroupDao.findById(id));
        }
        return albumDao.makePersistent(album, true);
    }

}
