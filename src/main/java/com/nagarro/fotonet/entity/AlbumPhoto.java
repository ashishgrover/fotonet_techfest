package com.nagarro.fotonet.entity;

import java.io.Serializable;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author ashish1813
 */
@Entity
@Table(name="album_photo")
@AssociationOverrides({
        @AssociationOverride(name="pk.album",
            joinColumns={@JoinColumn(name="albumid")}),
        @AssociationOverride(name="pk.photo",
            joinColumns={@JoinColumn(name="photoid")}
        )})
public class AlbumPhoto implements Serializable{
    
    private AlbumPhotoId pk = new AlbumPhotoId();

    private MediaEffects effect;

    private Frame frame;

    @EmbeddedId
    public AlbumPhotoId getPk() {
        return pk;
    }

    public void setPk(AlbumPhotoId pk) {
        this.pk = pk;
    }

    @OneToOne
    @JoinColumn(name="effect")
    public MediaEffects getEffect() {
        return effect;
    }

    public void setEffect(MediaEffects effect) {
        this.effect = effect;
    }

    @OneToOne
    @JoinColumn(name="frame")
    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    @Transient
    public Album getAlbum(){
        return getPk().getAlbum();
    }
    
    public void setAlbum(Album album){
        getPk().setAlbum(album);
    }
    
    @Transient
    public Photo getPhoto(){
        return getPk().getPhoto();
    }
    
    public void setPhoto(Photo photo){
        getPk().setPhoto(photo);
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.pk != null ? this.pk.hashCode() : 0);
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
        final AlbumPhoto other = (AlbumPhoto) obj;
        if (this.pk != other.pk && (this.pk == null || !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }
    
    
    
}
