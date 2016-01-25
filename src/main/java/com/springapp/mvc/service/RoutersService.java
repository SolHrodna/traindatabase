package com.springapp.mvc.service;


import com.springapp.mvc.domain.Routers;

import java.util.List;
import java.util.Set;

public interface RoutersService {

    public List<Routers> showAll();

    void addRoute(Routers routers);

    public List<Routers> findRouters(String station);

    void deleteById(Integer id);

    Routers find(Integer id);



    List<Routers> sortRoutes(Set<Routers> routerses);

    Routers sortRoute(Routers router);
}
