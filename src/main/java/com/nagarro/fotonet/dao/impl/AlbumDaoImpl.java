package com.nagarro.fotonet.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.nagarro.fotonet.dao.AlbumDao;
import com.nagarro.fotonet.entity.Album;

/**
 * @author shalini1814
 * 
 */
@Component
@Repository
public class AlbumDaoImpl extends AbstractGenericDao<Album, Integer> implements
        AlbumDao {


    @Override
    public List<Album> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Album> getAlbumsSharedWithUser(Integer userId) {
//        String queryStr = "";
//        Query query = em.createQuery(queryStr);
//        query.setParameter("uploaderId", userId);
//        List<Album> albums = query.getResultList();
//
//        return albums;
        throw new UnsupportedOperationException("Not supported yet!");
    }
}
