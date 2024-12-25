package com.hr.quiz_application.controller;

import com.hr.quiz_application.entity.Users;
import com.hr.quiz_application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ModelAndView registerUser(@RequestParam("name") String name,
                                     @RequestParam("email") String email,
                                     @RequestParam("psw") String psw) {
        Users user = new Users();
        user.setName(name);
        user.setEmail(email);
        user.setPsw(psw);
        userService.userRegistration(user);
        return new ModelAndView("success", "message", "Registered Successfully");
    }
}