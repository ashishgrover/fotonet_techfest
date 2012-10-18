package com.nagarro.fotonet.dao.impl;

import com.nagarro.fotonet.dao.UserDao;
import com.nagarro.fotonet.entity.User;
import java.util.List;
import javax.persistence.NonUniqueResultException;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractGenericDao<User, Integer>
implements UserDao  {

    @Override
    public User getUser(Integer subscriptionId) throws NonUniqueResultException {
        User user = null;
        
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq("subscription_id", subscriptionId));
        List users = criteria.list();
        if(users.size()>1){
            throw new NonUniqueResultException();
        }
        else if(users.size()==1){
            user = (User) users.get(0);
        }
        return user;
    }
}
