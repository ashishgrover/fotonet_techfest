/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nagarro.fotonet.controller;

import com.nagarro.fotonet.dao.AlbumDao;
import com.nagarro.fotonet.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ashish1813
 */
@Controller
@RequestMapping("test")
public class TestController {
    
    private AlbumDao albumDao;

    @Autowired
    public void setAlbumDao(AlbumDao albumDao) {
        this.albumDao = albumDao;
    }
    
    
    @RequestMapping(method = RequestMethod.GET)
    public String createDummyItem(ModelMap model) {
        Album album = new Album();
        album.setAlbumName("dummyAlbum");
        album.setPublished(false);
        
        albumDao.makePersistent(album, true);
        
        return "home";
    }
    
}
