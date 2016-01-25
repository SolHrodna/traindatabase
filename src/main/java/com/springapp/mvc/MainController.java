package com.springapp.mvc;

import com.springapp.mvc.domain.Routers;
import com.springapp.mvc.domain.Stations;
import com.springapp.mvc.domain.Train;
import com.springapp.mvc.service.Impl.RoutersServiceImpl;
import com.springapp.mvc.service.Impl.StationsServiceImpl;
import com.springapp.mvc.service.Impl.UserServiceImpl;
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
public class MainController {

	@Autowired
	UserServiceImpl userService;

	@Autowired
	RoutersServiceImpl routersService;

	@Autowired
	StationsServiceImpl stationsService;






	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView printWelcome(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView model = new ModelAndView("hello");
		model.addObject("message", "Please inter your login and password.");
		return model;
	}













}