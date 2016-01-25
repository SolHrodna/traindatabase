package com.springapp.mvc.domain;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ROUTERS")
public class Routers {

    @Id
    @Column(name = "routeId")
    @GeneratedValue
    private Integer routeId;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "QUEUE")
    private String queue;



    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "STATIONS_ROUTERS",
            joinColumns = {@JoinColumn(name = "ROUTE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "STATION_ID")})
    private Set<Stations> stationsSet = new HashSet<Stations>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainId")
    private Train train;

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Routers() {

    }

    public Routers(Date date, Set<Stations> stationsSet, Train train) {
        this.date = date;
        this.stationsSet = stationsSet;
        this.train = train;
    }

    public void setStationsSet(Set<Stations> stationsSet) {
        this.stationsSet = stationsSet;
    }


    public Set<Stations> getStationsSet() {

        return stationsSet;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public Date getDate() {
        return date;
    }






    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public void setDate(Date date) {
        this.date = date;
    }






}
