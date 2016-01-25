package com.springapp.mvc.DAO.Impl;

import com.springapp.mvc.DAO.MainDAO;
import com.springapp.mvc.DAO.OrderDAO;
import com.springapp.mvc.domain.Order;
import org.springframework.stereotype.Repository;


@Repository
public class OrderDAOImpl extends MainDAOImpl<Order> implements OrderDAO{

    public OrderDAOImpl(){super(Order.class);}

}
