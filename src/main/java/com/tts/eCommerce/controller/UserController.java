package com.tts.eCommerce.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tts.eCommerce.model.User;
import com.tts.eCommerce.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {
@Autowired
private UserService userService;

@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
public ModelAndView login(){
	System.out.println("Successfully Tested in login");
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("login");
    return modelAndView;
}

@RequestMapping(value="/user", method = RequestMethod.GET)
public ModelAndView userRegistration(){
	System.out.println("****************************Display User Registration Screen");
	
    ModelAndView modelAndView = new ModelAndView();
    User user = new User();
    modelAndView.addObject("user", user);
    modelAndView.setViewName("user");
    
    return modelAndView;
}

@RequestMapping(value = "/user", method = RequestMethod.POST)
public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
	System.out.println("*******************************Inside Save New User REgistration");

    ModelAndView modelAndView = new ModelAndView();
    User userExists = userService.findByUsername(user.getEmail());
    if (userExists != null) {
        bindingResult
                .rejectValue("email", "error.user",
                        "There is already a user registered with the email provided");
    }
    if (bindingResult.hasErrors()) {
        modelAndView.setViewName("user");
    } else {
        userService.saveNewUser(user);
        modelAndView.addObject("successMessage", "User has been registered successfully");
        modelAndView.addObject("user", new User());

        modelAndView.setViewName("user");

    }
    return modelAndView;
}

@RequestMapping(value="/admin/admin", method = RequestMethod.GET)
public ModelAndView home(){
	System.out.println("InsideadminHomePage");
    ModelAndView modelAndView = new ModelAndView();
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    User user = userService.findByUsername(auth.getName());
    modelAndView.addObject("userName", "Welcome " + user.getUsername() + " " + user.getLastname() + " (" + user.getEmail() + ")");
    modelAndView.addObject("adminMessage","This Page is available to Users with Admin Role");
    modelAndView.setViewName("admin/admin");
    return modelAndView;
}

@RequestMapping(value="/user/userHome", method = RequestMethod.GET)
public ModelAndView user(){
    ModelAndView modelAndView = new ModelAndView();
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    User user = userService.findByUsername(auth.getName());
    modelAndView.addObject("userName", "Welcome " + user.getUsername() + " " + user.getLastname() + " (" + user.getEmail() + ")");
    modelAndView.addObject("userMessage","This Page is available to Users with User Role");
    modelAndView.setViewName("user/userHome");
    return modelAndView;
}
}
