package com.springapp.mvc;


import com.springapp.mvc.domain.*;
import com.springapp.mvc.service.Impl.*;
import com.sun.javafx.sg.prism.NGShape;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class AdminController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    RoutersServiceImpl routersService;

    @Autowired
    StationsServiceImpl stationsService;

    @Autowired
    TrainServiceImpl trainService;

    @Autowired
    OrderServiceImpl orderService;


    List<Stations> slist = new ArrayList<Stations>();



    @RequestMapping(value = "/addRoute", method = RequestMethod.POST)
    public ModelAndView addRoute(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        ModelAndView model = new ModelAndView("admin");

        List<Stations> stationsList = stationsService.showAll();
        List<Routers> routersList = routersService.showAll();
        List<User> userList = userService.showAll();
        List<Train> trainList = trainService.showAll();
        Object value = request.getParameter("addStation");


        if (value.equals("add")){


            Integer id = Integer.valueOf(request.getParameter("stationSelect"));
            Stations newStation = stationsService.findById(id);
            Integer test = newStation.getStationId();
            slist.add(newStation);
            model.addObject("stationNew", slist);

        } else if (value.equals("remove")){

            Integer id = Integer.valueOf(request.getParameter("stationNew"));
            Stations newStation = stationsService.findById(id);
            for (Stations stations: slist){

                if (stations.getStation().equals(newStation.getStation())){
                    slist.remove(stations);
                    break;

                }
            }
            model.addObject("stationNew", slist);

        } else if (value.equals("addRoute")){

            Routers route = new Routers();

            String date = request.getParameter("date");
            String time = request.getParameter("time");

            String queue = "";

            for (Stations stations: slist){

                queue = queue + stations.getStationId() + " ";

            }



            String oldstring = date + " " + time;
            Date newdate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(oldstring);

            route.setDate(newdate);
            LinkedHashSet<Stations> stationsSet = new LinkedHashSet<Stations>(slist);

            String s = request.getParameter("trainSelectAdd");

            Stations stations = new Stations();

            Integer trainId = Integer.valueOf(s);



            Train train = trainService.find(trainId);


            route.setTrain(train);
            route.setStationsSet(stationsSet);

            route.setQueue(queue);

            routersService.addRoute(route);

        } else if (value.equals("clear")){

            slist.clear();
        }




        model.addObject("stationsList", stationsList);
        model.addObject("routersList", routersList);
        model.addObject("userList", userList);
        model.addObject("trainList", trainList);
        return model;
    }

    @RequestMapping(value = "/addStation", method = RequestMethod.POST)
    public ModelAndView addNewStation(HttpServletRequest request, HttpServletResponse response){

        ModelAndView model = new ModelAndView("admin");



        Stations station = new Stations();

        String name = request.getParameter("station");

        station.setStation(name);

        stationsService.addStation(station);

        List<Stations> stationsList = stationsService.showAll();
        List<Routers> routersList = routersService.showAll();
        List<User> userList = userService.showAll();
        List<Train> trainList = trainService.showAll();
        model.addObject("stationsList", stationsList);
        model.addObject("routersList", routersList);
        model.addObject("userList", userList);
        model.addObject("trainList", trainList);


        return model;
    }

    @RequestMapping(value = "/deleteStation", method = RequestMethod.POST)
    public ModelAndView deleteStation(HttpServletRequest request, HttpServletResponse response){

        ModelAndView model = new ModelAndView("admin");

        Integer id = Integer.valueOf(request.getParameter("stationSelect"));

        stationsService.delete(id);
        List<Stations> stationsList = stationsService.showAll();
        List<Routers> routersList = routersService.showAll();
        List<User> userList = userService.showAll();
        List<Train> trainList = trainService.showAll();
        model.addObject("stationsList", stationsList);
        model.addObject("routersList", routersList);
        model.addObject("userList", userList);
        model.addObject("trainList", trainList);


        return model;

    }

    @RequestMapping(value = "/deleteRoute", method = RequestMethod.POST)
    public ModelAndView deleteRoute(HttpServletRequest request, HttpServletResponse response){

        ModelAndView model = new ModelAndView("admin");

        Integer id = Integer.valueOf(request.getParameter("routeSelect"));

        routersService.deleteById(id);

        List<Stations> stationsList = stationsService.showAll();
        List<Routers> routersList = routersService.showAll();
        List<User> userList = userService.showAll();
        List<Train> trainList = trainService.showAll();
        model.addObject("stationsList", stationsList);
        model.addObject("routersList", routersList);
        model.addObject("userList", userList);
        model.addObject("trainList", trainList);

        return model;
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public ModelAndView deleteUser(HttpServletRequest request, HttpServletResponse response){

        ModelAndView model = new ModelAndView("admin");


        Integer id = Integer.valueOf(request.getParameter("userSelect"));

        userService.deleteById(id);

        List<Stations> stationsList = stationsService.showAll();
        List<Routers> routersList = routersService.showAll();
        List<User> userList = userService.showAll();
        List<Train> trainList = trainService.showAll();
        model.addObject("stationsList", stationsList);
        model.addObject("routersList", routersList);
        model.addObject("userList", userList);
        model.addObject("trainList", trainList);


        return model;

    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response){

        ModelAndView model = new ModelAndView("admin");

        User user= new User();

        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        user.setFirstname(request.getParameter("fname"));
        user.setSecondname(request.getParameter("sname"));

        userService.addUser(user);




        List<Stations> stationsList = stationsService.showAll();
        List<Routers> routersList = routersService.showAll();
        List<User> userList = userService.showAll();
        List<Train> trainList = trainService.showAll();
        model.addObject("stationsList", stationsList);
        model.addObject("routersList", routersList);
        model.addObject("userList", userList);
        model.addObject("trainList", trainList);


        return model;

    }

    @RequestMapping(value = "/deleteTrain", method = RequestMethod.POST)
    public ModelAndView deleteTrain(HttpServletRequest request, HttpServletResponse response){

        ModelAndView model = new ModelAndView("admin");


        Integer id = Integer.valueOf(request.getParameter("trainSelect"));

        trainService.deleteById(id);

        List<Stations> stationsList = stationsService.showAll();
        List<Routers> routersList = routersService.showAll();
        List<User> userList = userService.showAll();
        List<Train> trainList = trainService.showAll();
        model.addObject("stationsList", stationsList);
        model.addObject("routersList", routersList);
        model.addObject("userList", userList);
        model.addObject("trainList", trainList);


        return model;

    }

    @RequestMapping(value = "/addTrain", method = RequestMethod.POST)
    public ModelAndView addTrain(HttpServletRequest request, HttpServletResponse response){

        ModelAndView model = new ModelAndView("admin");

        Train train = new Train();

        train.setNumber(request.getParameter("number"));
        train.setModel(request.getParameter("model"));
        train.setNumPlaces(Integer.valueOf(request.getParameter("nplaces")));

        trainService.addTrain(train);






        List<Stations> stationsList = stationsService.showAll();
        List<Routers> routersList = routersService.showAll();
        List<User> userList = userService.showAll();
        List<Train> trainList = trainService.showAll();
        model.addObject("stationsList", stationsList);
        model.addObject("routersList", routersList);
        model.addObject("userList", userList);
        model.addObject("trainList", trainList);


        return model;

    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public ModelAndView editUser(HttpServletRequest request, HttpServletResponse response){

        ModelAndView model = new ModelAndView("usereditor");



        Integer userid = Integer.valueOf(request.getParameter("userSelect"));

        Order order = orderService.find(14);

        User user = userService.findById(userid);

        request.getSession().setAttribute("userEdit", user);

        model.addObject("user", user);


        return model;
    }
}
