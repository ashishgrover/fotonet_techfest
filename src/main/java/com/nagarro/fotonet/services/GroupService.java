package com.nagarro.fotonet.services;

import com.nagarro.fotonet.entity.BuddyGroup;
import java.util.Collection;

/**
 *
 * @author ashish1813
 */
public interface GroupService {
    
    /**
     * Creates a new buddy group.
     * 
     * @param ownerId ID of user owning the group
     * @param groupName Name of the group
     * @param memberIds IDs of User that will be group members
     * @return Created BuddyGroup
     */
    BuddyGroup addBuddyGroup(Integer ownerId, String groupName, Collection<Integer> memberIds);
      
    
    
}
