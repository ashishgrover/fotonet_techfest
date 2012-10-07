package com.nagarro.fotonet.services.impl;

import com.nagarro.fotonet.dao.AlbumDao;
import com.nagarro.fotonet.dao.UserDao;
import com.nagarro.fotonet.entity.Album;
import com.nagarro.fotonet.exceptions.ItemNotFoundException;
import com.nagarro.fotonet.exceptions.ItemOverwriteException;
import com.nagarro.fotonet.services.AlbumService;
import java.util.List;
import javax.persistence.EntityNotFoundException;
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

    public void setAlbumDao(AlbumDao albumDao) {
        this.albumDao = albumDao;
    }

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public void createAlbum(Album album) throws ItemOverwriteException {
        try{
            albumDao.getReference(album.getId());
        }
        catch(EntityNotFoundException enfe){
            albumDao.makePersistent(album, true);
        }
        throw new ItemOverwriteException("Album already exists.");
    }

    @Override
    public void updateAlbum(Album album) {
        albumDao.makePersistent(album, true);
    }

    @Override
    public Album getAlbumById(Integer id) throws ItemNotFoundException {
        Album album = albumDao.findById(id);
        if (album==null) {
            throw new ItemNotFoundException("No Album exists for given ID");
        }
        return album;
    }

    @Override
    public List<Album> getAlbumsSharedWithUser(Integer userId) throws ItemNotFoundException {
        try{
            userDao.getReference(userId);
        }
        catch(EntityNotFoundException enfe){
            throw new ItemNotFoundException("User with ID: " + userId + " does not exist!");
        }
        return albumDao.getAlbumsSharedWithUser(userId);
    }

}
