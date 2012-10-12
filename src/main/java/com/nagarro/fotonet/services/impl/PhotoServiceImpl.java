package com.nagarro.fotonet.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.fotonet.common.Constants;
import com.nagarro.fotonet.dao.PhotoDao;
import com.nagarro.fotonet.entity.Photo;
import com.nagarro.fotonet.services.PhotoService;
import com.nagarro.fotonet.utils.PhotoUploadUtil;

/**
 * 
 * @author shalini1814
 * 
 */
@Service
@Transactional
public class PhotoServiceImpl implements PhotoService {

	@Autowired
	private PhotoDao photoDao;

        public void setPhotoDao(PhotoDao photoDao) {
            this.photoDao = photoDao;
	}

	@Override
	public List<Photo> getPhotosInAlbum(Integer albumId) {
            return photoDao.getPhotosInAlbum(albumId);
	}

	@Override
	public void uploadPhoto(Photo photo) {

            photo.setCreatedOn(new Date());
            photo.setPhotoName(photo.getFileData().getOriginalFilename());

            StringBuilder path = new StringBuilder(Constants.STORAGE_PATH);
            path.append("\\").append(111)
                            .append("\\").append(photo.getFileData().getOriginalFilename());
            photo.setPhysicalPath(path.toString());

            photo.setVersion(1);
            photoDao.makePersistent(photo, false);
            PhotoUploadUtil.sendPhotoToServer(photo);
	}


	
}
