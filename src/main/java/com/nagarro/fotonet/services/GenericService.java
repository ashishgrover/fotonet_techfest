package com.nagarro.fotonet.services;

import com.nagarro.fotonet.exceptions.ItemNotFoundException;
import com.nagarro.fotonet.exceptions.ItemOverwriteException;

/**
 *
 * @author ashish1813
 */
public interface GenericService<T> {

    /**
     * Creates an Item.
     *
     * @param T Item to be created
     */
    void createAlbum(T item)
            throws ItemOverwriteException;

    /**
     * Updates the Item .
     * @param T Item to be updated
     */
    void updateAlbum(T item);


    /**
     * Returns Item with given {@code id}.
     *
     * @param id ID of the required Item
     * @return T with {@code id}
     */
    T getAlbumById(Integer id)
            throws ItemNotFoundException;


}
