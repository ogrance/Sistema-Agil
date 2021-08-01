package com.example.SistemaAgil_IS2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public ModelAndView pantallaLogin(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("paginaLogin");
        return mav;
    }
}
