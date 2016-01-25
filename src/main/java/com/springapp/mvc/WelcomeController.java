package com.springapp.mvc;


import com.springapp.mvc.domain.Routers;
import com.springapp.mvc.domain.Stations;
import com.springapp.mvc.domain.Train;
import com.springapp.mvc.domain.User;
import com.springapp.mvc.service.Impl.RoutersServiceImpl;
import com.springapp.mvc.service.Impl.StationsServiceImpl;
import com.springapp.mvc.service.Impl.TrainServiceImpl;
import com.springapp.mvc.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WelcomeController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    RoutersServiceImpl routersService;

    @Autowired
    StationsServiceImpl stationsService;

    @Autowired
    TrainServiceImpl trainService;



    List<Stations> slist = new ArrayList<Stations>();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView print(HttpServletRequest request, HttpServletResponse response) throws ParseException {


        String loginUser = request.getParameter("loginAut");
        String passwordUser = request.getParameter("passwordAut");
        User user = new User();
        user.setLogin(loginUser);
        user.setPassword(passwordUser);


        List<Stations> stationsList = stationsService.showAll();
        List<Routers> routersList = routersService.showAll();
        List<User> userList = userService.showAll();
        List<Train> trainList = trainService.showAll();


        List<Integer> userAut = userService.compareUser(user);

        if (userAut.get(0) == 2) {

            ModelAndView model = new ModelAndView("main");

            request.getSession().setAttribute("userId", userAut.get(1));

            model.addObject("stationsList", stationsList);


            return model;

        } else if (userAut.get(0) == 1) {

            ModelAndView model = new ModelAndView("admin");
            request.getSession().setAttribute("userId", userAut.get(1));
            model.addObject("stationsList", stationsList);
            model.addObject("routersList", routersList);
            model.addObject("userList", userList);
            model.addObject("trainList", trainList);
            model.addObject("stationNew", slist);


            return model;

        } else {

            ModelAndView model = new ModelAndView("hello");
            model.addObject("message", "Please inter your Login and Password.");
            model.addObject("warning", "Error! Wrong Login or Password!");
            return model;

        }
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registration(HttpServletRequest request, HttpServletResponse response){

        ModelAndView model = new ModelAndView("reg");

        return model;
    }

    @RequestMapping(value = "/registrationUser", method = RequestMethod.POST)
    public ModelAndView registrationUser(HttpServletRequest request, HttpServletResponse response){

        ModelAndView model = new ModelAndView("reg");

        List<User> userList = userService.showAll();
        User user= new User();



        user.setLogin(request.getParameter("loginReg"));
        user.setPassword(request.getParameter("passwordReg"));
        user.setFirstname(request.getParameter("fnameReg"));
        user.setSecondname(request.getParameter("snameReg"));

        for(User users: userList){

            if(users.getLogin().equals(user.getLogin())){

            } else {userService.addUser(user);}

        }




        return model;
    }

}
