package com.springapp.mvc.DAO.Impl;


import com.springapp.mvc.DAO.StationsDAO;
import com.springapp.mvc.domain.Stations;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class StationsDAOImpl extends MainDAOImpl<Stations> implements StationsDAO{

    public StationsDAOImpl() {
        super(Stations.class);
    }




    @Override
    @Transactional
    public void addNewStation(Stations station){

        List<Stations> stationsList = this.showAll();
        boolean flag = true;

        for (Stations stations: stationsList){

            if (stations.getStation().equals(station.getStation())){

                flag = false;

            }

        }

        if (flag) {

            this.save(station);

        }

    }
}
