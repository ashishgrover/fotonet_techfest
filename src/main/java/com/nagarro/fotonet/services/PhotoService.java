package com.nagarro.fotonet.services;


import com.nagarro.fotonet.entity.Comment;
import com.nagarro.fotonet.entity.Photo;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author shalini1814
 *
 */
public interface PhotoService {

   
    /**
     * 
     * @param albumId
     * @return
     */
    Collection<Photo> getPhotosInAlbum(Integer albumId);
    
    /**
     * 
     */
    void uploadPhoto(Photo photo);
    
    /**
     * Fetches the comments for a photo in order they were published.
     * Latest published is first.
     * 
     * @param photoId ID of Photo to get comment for
     * @return Comments for photo
     */
    List<Comment> getPhotoComments(Integer photoId);
    
    /**
     * Creates a new comment for a photo with ID as {@code photoId}.
     * 
     * @param photoId ID of photo to add comment to
     * @param comment Content of comment
     * @return Persisted Photo with comment added
     */
    Photo addComment(Integer photoId, String comment);
    
    /**
     * Removes a Comment from Photo
     * 
     * @param photoId ID of Photo to remove comment from
     * @param commentId ID of comment to be removed
     * @return Persisted Photo with comment removed
     */
    Photo removeComment(Integer photoId, Integer commentId);
    
    /**
     * Configures the Photo to allow or disallow comments on it.
     * 
     * @param photoId ID of Photo to allow/disallow comments on
     * @param allowComments True value allows comments
     * @return Persisted Photo with comments allowed/disallowed
     */
    Photo setCommentsModeration(Integer photoId, Boolean allowComments);   
    
    /**
     * Add tags to a Photo
     * 
     * @param photoId ID of photo to tag
     * @param tags Tags to be added
     * @return  Updated Photo
     */
    Photo addPhotoTags(Integer photoId, Collection<String> tags);
    
    
    /**
     * Delete tags from photo
     * 
     * @param photoId ID of photo to remove from
     * @param tagIds IDs of tags to be removed
     * @return 
     */
    Photo removePhotoTags(Integer photoId, Collection<Integer> tagIds);
    
    
    
    /**
     * Get photos filtered on the basis of {@code whereParams} 
     * 
     * @param whereParams Filter parameters
     * @return Filtered Photos collection
     */
    @Deprecated //DEFER IMPLEMENTATION
    Collection<Photo> getFilteredPhotos(Map<String, String> whereParams);

    
    /**
     * Updates photo
     * 
     * @param photo
     * @return Updated photo
     */
    Photo updatePhoto(Photo photo);
    
}
