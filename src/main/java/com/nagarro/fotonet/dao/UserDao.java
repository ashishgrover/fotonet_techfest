package com.nagarro.fotonet.dao;

import com.nagarro.fotonet.entity.User;
import javax.persistence.NonUniqueResultException;

/**
 * @author shalini1814
 *
 */
public interface UserDao extends 
GenericDao<User,Integer> {
    
    
    /**
     * This API checks for user with given subscriptionId.
     * @param subscriptionId
     * @return
     */
    User getUser(Integer subscriptionId) throws NonUniqueResultException;
    

}
