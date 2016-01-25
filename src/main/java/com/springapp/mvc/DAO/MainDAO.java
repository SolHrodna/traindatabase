package com.springapp.mvc.DAO;


import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MainDAO<T> {

    @Transactional
    public List<T> showAll();

    @Transactional
    public void save(T item);

    @Transactional
    T findById(Integer id);

    @Transactional
    public void delete(T item);


    @Transactional
    void deletebyId(Integer id);
}
