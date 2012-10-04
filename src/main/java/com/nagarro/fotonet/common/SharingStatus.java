package com.nagarro.fotonet.common;

/**
 * Sharing statuses for albums. An album can only have
 * one of the defined status at a particular time.
 *
 * @author ashish1813
 */
public enum SharingStatus {

    /*
     * PRIVATE: Self only
     * PUBLIC: Everyone
     * SELECTIVE: Chosen buddy groups only
     * INVALID: Album is unpublished, status have no meaning
     */
    PRIVATE, PUBLIC, SELECTIVE, INVALID;

}
