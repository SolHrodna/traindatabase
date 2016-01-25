package com.springapp.mvc.service.Impl;


import com.springapp.mvc.DAO.UserDAO;
import com.springapp.mvc.domain.User;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;


    @Override
    public void save(User user){

        userDAO.save(user);
    }

    @Override
    public List<User> showAll() {

        return userDAO.showAll();

    }

    @Override
    public void addUser(User user) {

        userDAO.addNewUser(user);

    }

    @Override
    public List<Integer> compareUser(User user){

        return userDAO.compare(user);
    }

    @Override
    public void deleteById(Integer id){

        userDAO.deletebyId(id);

    }

    @Override
    public User findById(Integer id){

        return userDAO.findById(id);
    }
}
