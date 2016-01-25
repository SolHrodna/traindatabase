package com.springapp.mvc;


import com.springapp.mvc.domain.*;
import com.springapp.mvc.service.Impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

@Controller
public class UserEditorController {


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

    @RequestMapping(value = "/exitFromEditor", method = RequestMethod.POST)
    public ModelAndView exitEditor(HttpServletRequest request, HttpServletResponse response){

        ModelAndView model = new ModelAndView("admin");

        List<Stations> stationsList = stationsService.showAll();
        List<Routers> routersList = routersService.showAll();
        List<User> userList = userService.showAll();
        List<Train> trainList = trainService.showAll();

        model.addObject("stationsList", stationsList);
        model.addObject("routersList", routersList);
        model.addObject("userList", userList);
        model.addObject("trainList", trainList);
        model.addObject("stationNew", slist);


        return model;
    }

    @RequestMapping(value = "/cancelOrder", method = RequestMethod.POST)
    public ModelAndView cancelOrder(HttpServletRequest request, HttpServletResponse response){

        ModelAndView model = new ModelAndView("admin");




        return model;
    }

    @RequestMapping(value = "/deleteOrderEditor", method = RequestMethod.POST)
    public ModelAndView deleteOrderEditor(HttpServletRequest request, HttpServletResponse response){

        ModelAndView model = new ModelAndView("usereditor");

        String value = request.getParameter("orderDelete");

        User user = (User) request.getSession().getAttribute("userEdit");

        //orderService.delete(orderService.find(Integer.valueOf(value)));

        Order order = orderService.find(Integer.valueOf(value));
        order.setStatus("Deleted");

        orderService.addOrder(order);


        User userReturn = userService.findById(user.getUserId());




        model.addObject("user", userReturn);






        return model;
    }

    @RequestMapping(value = "/editOrderEditor", method = RequestMethod.POST)
    public ModelAndView editOrderEditor(HttpServletRequest request, HttpServletResponse response){

        ModelAndView model = new ModelAndView("usereditor");

        String value = request.getParameter("orderCancel");

        User user = (User) request.getSession().getAttribute("userEdit");

        Order order = orderService.find(Integer.valueOf(value));
        order.setStatus("Canceled");

        orderService.addOrder(order);

        User userReturn = userService.findById(user.getUserId());




        model.addObject("user", userReturn);






        return model;
    }
}
