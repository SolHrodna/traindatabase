package com.springapp.mvc.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "STATIONS")
public class Stations {

    @Id
    @Column(name = "stationId")
    @GeneratedValue
    private Integer stationId;

    @Column(name = "STATION")
    private String station;

    /*@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Routers> routersSet = new HashSet<Routers>();*/

    public Stations() {

    }

    public Stations(Integer stationId, String station) {

        this.stationId = stationId;
        this.station = station;
    }

    public Stations(String station) {
        this.station = station;
    }

   /*public Stations(String station, Set<Routers> routersSet) {
        this.station = station;
        this.routersSet = routersSet;
    }



    public Set<Routers> getRoutersSet() {
        return routersSet;
    }

    public void setRoutersSet(Set<Routers> routersSet) {
        this.routersSet = routersSet;
    }*/

    public Integer getStationId() {
        return stationId;
    }

    public String getStation() {
        return station;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public void setStation(String station) {
        this.station = station;
    }
}
