package com.nagarro.fotonet.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.fotonet.common.Constants;
import com.nagarro.fotonet.dao.PhotoDao;
import com.nagarro.fotonet.entity.Comment;
import com.nagarro.fotonet.entity.Photo;
import com.nagarro.fotonet.services.PhotoService;
import com.nagarro.fotonet.utils.PhotoUploadUtil;
import java.util.Collection;
import java.util.Map;

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

    @Override
    public Collection<Photo> getPhotosInAlbum(Integer albumId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Comment> getPhotoComments(Integer photoId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Photo addComment(Integer photoId, String comment) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Photo removeComment(Integer photoId, Integer commentId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Photo setCommentsModeration(Integer photoId, Boolean allowComments) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Photo addPhotoTags(Integer photoId, Collection<String> tags) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Photo removePhotoTags(Integer photoId, Collection<Integer> tagIds) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<Photo> getFilteredPhotos(Map<String, String> whereParams) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Photo updatePhoto(Photo photo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


	
}
