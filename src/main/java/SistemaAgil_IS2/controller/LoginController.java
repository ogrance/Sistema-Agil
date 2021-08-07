package SistemaAgil_IS2.controller;

import SistemaAgil_IS2.model.Usuario;
import SistemaAgil_IS2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    private UsuarioService usuarioService;
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public ModelAndView pantallaLogin(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mav = new ModelAndView("paginaLogin");
        mav.addObject("usuario",new Usuario());
        return mav;
    }

    @RequestMapping(value = "procesarLogin",method = RequestMethod.POST)
    public ModelAndView procesarLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("usuario") Usuario user){
        ModelAndView mav= new ModelAndView("bienvenido");
        try {
        Usuario u=usuarioService.validarUsuario(user);
            if(u!=null){
                return  mav.addObject("laBienvenida",u.getNombre());
            }else{
                mav.setViewName("paginaLogin");
                mav.addObject("registoIncorrecto","El usuario y/o la contraseña no corresponden");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return mav;
    }

}