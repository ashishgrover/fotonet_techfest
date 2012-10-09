package com.nagarro.fotonet.services;

import com.nagarro.fotonet.dao.GenericDao;
import com.nagarro.fotonet.entity.AbstractEntity;
import com.nagarro.fotonet.exceptions.ItemNotFoundException;
import com.nagarro.fotonet.exceptions.ItemOverwriteException;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author ashish1813
 */
public class AbstractGenericService<T extends AbstractEntity> implements GenericService<T> {

    GenericDao<T, Integer> dao;

    public void setDao(GenericDao<T, Integer> dao) {
        this.dao = dao;
    }


    @Override
    public void createAlbum(T item) throws ItemOverwriteException {
        try{
            dao.getReference(item.getId());
        }
        catch(EntityNotFoundException enfe){
            dao.makePersistent(item, true);
        }
        throw new ItemOverwriteException("Item already exists.");
    }

    @Override
    public void updateAlbum(T item) {
        dao.makePersistent(item, true);
    }

    @Override
    public T getAlbumById(Integer id) throws ItemNotFoundException {
        T item = dao.findById(id);
        if (item==null) {
            throw new ItemNotFoundException("No Item exists for given ID");
        }
        return item;
    }

}
