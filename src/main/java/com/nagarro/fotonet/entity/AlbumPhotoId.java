package com.nagarro.fotonet.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 *
 * @author ashish1813
 */
@Embeddable
public class AlbumPhotoId implements Serializable{
    
    @ManyToOne
    private Album album;
    
    @ManyToOne
    private Photo photo;

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.album != null ? this.album.hashCode() : 0);
        hash = 41 * hash + (this.photo != null ? this.photo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AlbumPhotoId other = (AlbumPhotoId) obj;
        if (this.album != other.album && (this.album == null || !this.album.equals(other.album))) {
            return false;
        }
        if (this.photo != other.photo && (this.photo == null || !this.photo.equals(other.photo))) {
            return false;
        }
        return true;
    }
    
    
    
}
