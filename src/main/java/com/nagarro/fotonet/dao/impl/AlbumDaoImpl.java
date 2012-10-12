package com.nagarro.fotonet.dao.impl;

import com.nagarro.fotonet.dao.AlbumDao;
import com.nagarro.fotonet.entity.Album;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

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

    @Override
    public Collection<Album> getPublicAlbumsOfUser(Integer ownerId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
