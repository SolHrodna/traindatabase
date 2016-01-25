package com.springapp.mvc;


import com.springapp.mvc.domain.Order;
import com.springapp.mvc.domain.Routers;
import com.springapp.mvc.domain.Stations;
import com.springapp.mvc.domain.User;
import com.springapp.mvc.service.Impl.OrderServiceImpl;
import com.springapp.mvc.service.Impl.RoutersServiceImpl;
import com.springapp.mvc.service.Impl.StationsServiceImpl;
import com.springapp.mvc.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class MPageController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    RoutersServiceImpl routersService;

    @Autowired
    StationsServiceImpl stationsService;

    @Autowired
    OrderServiceImpl orderService;

    ArrayList<Routers> routerOrder = new ArrayList<Routers>();


    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public ModelAndView find(HttpServletRequest request, HttpServletResponse response){

        ModelAndView model = new ModelAndView("main");
        Integer userid = (Integer) request.getSession().getAttribute("userId");
        List<Stations> stationsList = stationsService.showAll();
        String nameStationFrom = request.getParameter("stationSelectFrom");
        String nameStationTo = request.getParameter("stationSelectTo");
        List<Routers> routersList = routersService.findRouters(nameStationFrom);
        List<Routers> routersOutput = new ArrayList<Routers>();

        for (Routers routers: routersList){

            String[] queue = routers.getQueue().split(" ");
            LinkedHashSet<Stations> stationses = new LinkedHashSet<Stations>() ;

            int a = -1;
            int b = -1;

            for (int i = 0; i<queue.length; i++){



                Stations temp = stationsService.findById(Integer.valueOf(queue[i]));
                stationses.add(temp);

                if (temp.getStation().equals(nameStationFrom)){

                    a = i;

                } else if(temp.getStation().equals(nameStationTo)){

                    b = i;

                }



            }

            if ((a <= b)&(a!=-1)&(b!=-1)){

                routers.setStationsSet(stationses);
                routersOutput.add(routers);


            }








        }


        model.addObject("stationsList", stationsList);
        model.addObject("stations", routersOutput);

        return model;
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ModelAndView order(HttpServletRequest request, HttpServletResponse response){

        ModelAndView model = new ModelAndView("main");
        Integer userid = (Integer) request.getSession().getAttribute("userId");
        User user = userService.findById(userid);


        Integer value = Integer.valueOf(request.getParameter("orderButtom"));
        Order order = new Order("Not Paid");
        order.setRouters(routersService.find(value));



        //order.setRoute_id(Integer.valueOf(s));
        //order.setStatus("nopay");
        order.setUser(user);


        orderService.addOrder(order);





        List<Stations> stationsList = stationsService.showAll();
        model.addObject("stationsList", stationsList);



        //user.setOrderSet(orderSet);

        //userService.save(user);










        return model;
    }

    @RequestMapping(value = "/orderPage", method = RequestMethod.POST)
    public ModelAndView goOrderPage(HttpServletRequest request, HttpServletResponse response){

        ModelAndView model = new ModelAndView("order");
        Integer userid = (Integer) request.getSession().getAttribute("userId");

        User user = userService.findById(userid);

        LinkedHashSet<Order> orders = new LinkedHashSet<Order>();



        for(Order order: user.getOrderSet()){

            if(order.getStatus().equals("Not Paid")){



                Routers routers = routersService.sortRoute(routersService.find(order.getRouters().getRouteId()));
                order.setRouters(routers);
                orders.add(order);

            }



        }



        model.addObject("orderList",orders);




        return model;
    }


    @RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
    public ModelAndView deleteOrder(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView model = new ModelAndView("order");
        Integer userid = (Integer) request.getSession().getAttribute("userId");

        Integer value = Integer.valueOf(request.getParameter("orderDelete"));

        Order orderPay = orderService.find(value);
        User user = userService.findById(userid);

        orderPay.setStatus("Deleted");

        orderService.addOrder(orderPay);


        //orderService.delete(orderService.find(value));



        LinkedHashSet<Order> orders = new LinkedHashSet<Order>();



        for(Order order: user.getOrderSet()){

            if(order.getStatus().equals("Not Paid")){



                Routers routers = routersService.sortRoute(routersService.find(order.getRouters().getRouteId()));
                order.setRouters(routers);
                orders.add(order);

            }



        }



        model.addObject("orderList",orders);




            return model;
        }


    @RequestMapping(value = "/exitFromOrder", method = RequestMethod.POST)
    public ModelAndView exitOrder(HttpServletRequest request, HttpServletResponse response){

        ModelAndView model = new ModelAndView("/hello");
        Integer userid = (Integer) request.getSession().getAttribute("userId");



        routerOrder.clear();






        return model;
    }

    @RequestMapping(value = "/backOrder", method = RequestMethod.POST)
    public ModelAndView backOrder(HttpServletRequest request, HttpServletResponse response){

        ModelAndView model = new ModelAndView("/main");
        Integer userid = (Integer) request.getSession().getAttribute("userId");

        List<Stations> stationsList = stationsService.showAll();


        model.addObject("stationsList", stationsList);







        return model;
    }

    @RequestMapping(value = "/payOrder", method = RequestMethod.POST)
    public ModelAndView payOrder(HttpServletRequest request, HttpServletResponse response){

        ModelAndView model = new ModelAndView("order");
        Integer userid = (Integer) request.getSession().getAttribute("userId");

        Integer value = Integer.valueOf(request.getParameter("orderPay"));

        Order orderPay = orderService.find(value);
        User user = userService.findById(userid);

        orderPay.setStatus("Paid");

        orderService.addOrder(orderPay);

        LinkedHashSet<Order> orders = new LinkedHashSet<Order>();



        for(Order order: user.getOrderSet()){

            if(order.getStatus().equals("Not Paid")){



                Routers routers = routersService.sortRoute(routersService.find(order.getRouters().getRouteId()));
                order.setRouters(routers);
                orders.add(order);

            }



        }



        model.addObject("orderList",orders);

        return model;
    }

    @RequestMapping(value = "/showHistory", method = RequestMethod.POST)
    public ModelAndView showHistory(HttpServletRequest request, HttpServletResponse response){

        ModelAndView model = new ModelAndView("history");
        Integer userid = (Integer) request.getSession().getAttribute("userId");
        User user = userService.findById(userid);

        LinkedHashSet<Order> orders = new LinkedHashSet<Order>();



        for(Order order: user.getOrderSet()){

            if(order.getStatus().equals("Paid") || order.getStatus().equals("Canceled")){



                Routers routers = routersService.sortRoute(routersService.find(order.getRouters().getRouteId()));
                order.setRouters(routers);
                orders.add(order);

            }



        }



        model.addObject("orderList",orders);


        return  model;
    }

}
