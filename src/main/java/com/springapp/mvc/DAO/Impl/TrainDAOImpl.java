package com.springapp.mvc.DAO.Impl;


import com.springapp.mvc.DAO.TrainDAO;
import com.springapp.mvc.domain.Stations;
import com.springapp.mvc.domain.Train;
import org.springframework.stereotype.Repository;

@Repository
public class TrainDAOImpl extends MainDAOImpl<Train> implements TrainDAO{

    public TrainDAOImpl() {
        super(Train.class);
    }


}
