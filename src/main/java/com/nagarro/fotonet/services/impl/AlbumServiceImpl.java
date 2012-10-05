package com.nagarro.fotonet.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.fotonet.dao.AlbumDao;
import com.nagarro.fotonet.entity.Album;
import com.nagarro.fotonet.services.AlbumService;

/**
 * 
 * @author shalini1814
 *
 */
@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumDao albumDao;
    
    @Override
    public Album getAlbumById(Integer id) {
        return albumDao.findById(id);
    }
    
    @Override
    public List<Album> getAlbumsByUser(Integer userId) {
        return albumDao.getAlbumsByUser(userId);
    }
    
    public AlbumDao getAlbumDao() {
        return albumDao;
    }

    public void setAlbumDao(AlbumDao albumDao) {
        this.albumDao = albumDao;
    }

    @Override
    public void createAlbum(String name, Integer userId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Album getAlbumByUser(Integer userId, String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setAlbumName(Integer id, String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteAlbum(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteAlbum(Integer userId, String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
