package com.springapp.mvc.DAO.Impl;


import com.springapp.mvc.DAO.UserDAO;
import com.springapp.mvc.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;


@Repository
public class UserDAOImpl extends MainDAOImpl<User> implements UserDAO{


    @Autowired
    private SessionFactory sessionFactory;

    public UserDAOImpl() {
        super(User.class);
    }



    public UserDAOImpl(SessionFactory sessionFactory) {
    }

    @Override
    @Transactional
    public List<Integer> compare(User item) {

        List<Integer> out = new ArrayList<Integer>();

        out.add(0);

        List<User> users = this.showAll();
        for (User user : users) {

            if (user.getLogin().equals(item.getLogin()) && user.getPassword().equals(item.getPassword())) {

                if(user.getLogin().equals("admin") && user.getPassword().equals("admin")){

                    out.clear();
                    out.add(1);
                    out.add(user.getUserId());
                    break;

                } else {

                    out.clear();
                    out.add(2);
                    out.add(user.getUserId());

                    break;

                }

            }
        }

        return  out;
    }

    @Override
    @Transactional
    public void addNewUser(User user){

        List<User> userList = this.showAll();
        boolean flag = true;

        for (User users: userList){

            if (users.getLogin().equals(user.getLogin())){

                flag = false;

            }

        }

        if (flag) {

            this.save(user);

        }

    }
}
