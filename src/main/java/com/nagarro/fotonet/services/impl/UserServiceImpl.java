package com.nagarro.fotonet.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.fotonet.dao.UserDao;
import com.nagarro.fotonet.entity.User;
import com.nagarro.fotonet.services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userDao;
    
    @Override
    public User getUserById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public User getUserBySubscriptionId(Integer subscriptionId) {
        return userDao.getUser(subscriptionId);
    }

    public boolean checkUser(String name) {
        // TODO Auto-generated method stub
        return false;
    }
    
    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

	
    
}
