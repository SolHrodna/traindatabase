package com.springapp.mvc.DAO;


import com.springapp.mvc.domain.Routers;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoutersDAO extends MainDAO<Routers>{


    @Transactional
    List<Routers> findRoute(String station);



}
