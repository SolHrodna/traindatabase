package com.springapp.mvc.DAO.Impl;

import com.springapp.mvc.DAO.MainDAO;
import com.springapp.mvc.domain.Routers;
import com.springapp.mvc.domain.Stations;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Repository
public abstract class MainDAOImpl<T> implements MainDAO<T> {



    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> type;

    MainDAOImpl() {

    }

    MainDAOImpl(Class<T> type) {
        this.type = type;
    }


    @Override
    @Transactional
    public List<T> showAll() {


        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(type);
        List returns = criteria.list();

        return returns;
    }

    @Override
    @Transactional
    public void save(T item) {



        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(item);




    }

    @Override
    @Transactional
    public T findById(Integer id){

        Session session = sessionFactory.getCurrentSession();
        T item = (T) session.get(type, id);

        return item;

    }

    @Override
    @Transactional
    public void delete(T item) {

        Session session = sessionFactory.getCurrentSession();
        session.delete(item);

    }

    @Override
    @Transactional
    public void deletebyId(Integer id){

        Session session = sessionFactory.getCurrentSession();
        T item = this.findById(id);

        this.delete(item);

    }



}
