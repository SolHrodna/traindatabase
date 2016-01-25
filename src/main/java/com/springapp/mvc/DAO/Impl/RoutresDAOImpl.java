package com.springapp.mvc.DAO.Impl;

import com.springapp.mvc.DAO.RoutersDAO;
import com.springapp.mvc.domain.Routers;
import com.springapp.mvc.domain.Stations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoutresDAOImpl extends MainDAOImpl<Routers> implements RoutersDAO {

    public RoutresDAOImpl() {
        super(Routers.class);
    }



    @Override
    @Transactional
    public List<Routers> findRoute(String station){

        List<Routers> inRoutes = this.showAll();
        List<Routers> routeIndex = new ArrayList<Routers>();

        for(Routers routers: inRoutes){

            for (Stations stations: routers.getStationsSet()){

                if (stations.getStation().equals(station)){


                            routeIndex.add(routers);
                            break;



                }

            }

        }








        return routeIndex;
    }


    /*@Override
    @Transactional
    public void deleteById(Integer id){

        List<Routers> routersList = this.showAll();

        for (Routers routers: routersList){

            if (routers.getRouteId() == id){

                this.delete(routers);

            }

        }
    }*/
}
