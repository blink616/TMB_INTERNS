package com.Saud.springboothibernatelogin.dao;

import com.Saud.springboothibernatelogin.model.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

    @Repository
    public class UserDaoImpl {

        @Autowired
        private EntityManager em;

        public User save(User user) {
            Session session = em.unwrap(Session.class);
            session.persist(user);
            return user;
        }

    }
