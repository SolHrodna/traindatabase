package com.springapp.mvc.DAO;


import com.springapp.mvc.domain.User;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface UserDAO extends MainDAO<User>{



    @Transactional
    List<Integer> compare(User user);

    @Transactional
    void addNewUser(User user);
}
