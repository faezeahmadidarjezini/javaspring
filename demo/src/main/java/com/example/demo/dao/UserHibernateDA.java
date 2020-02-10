package com.example.demo.dao;

import com.example.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UserHibernateDA implements IUserDA {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void delete(String username) throws Exception { }

    @Override
    public void insert(User user) throws Exception { }


    public void save(User user){
        entityManager.persist(user);
    }

    @Override
    public List<User> select() throws Exception {
        return entityManager.createNativeQuery("select * from user").getResultList();

    }

    @Override
    public void update(User user) throws Exception { }

    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }
}
