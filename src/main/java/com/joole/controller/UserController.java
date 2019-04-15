package com.joole.controller;



import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.joole.domain.User;
import com.joole.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// user login
	@RequestMapping(value = "/user", method=RequestMethod.GET)
    public ModelAndView listEmployee(ModelAndView model) throws IOException {
        User user = userService.getUser(1);
        
        System.out.println(user);

        model.setViewName("home");
        return model;
    } 
	


}
