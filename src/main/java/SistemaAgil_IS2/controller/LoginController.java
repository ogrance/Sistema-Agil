package SistemaAgil_IS2.controller;

import SistemaAgil_IS2.model.RolesDetalle;
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
import java.util.List;

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
        /*Roles en BD
        *1-Seguridad
        *2-Proyecto
        * 3-Desarrollo
        */
        ModelAndView mav= new ModelAndView();
        boolean rolSeguridad=false;
        boolean rolProyecto=false;
        boolean rolDesarrollo=false;
        boolean rolInvalido=false;
        String nombre=null;
        try {
             List<RolesDetalle> rolesDetalle=usuarioService.validarUsuario(user);

             //System.out.println("tamanho de la lista: "+rolesDetalle.size());
                 if (rolesDetalle != null){
                     nombre=  rolesDetalle.get(0).getUser().getNombre()+" "+rolesDetalle.get(0).getUser().getApellido();
                    for(RolesDetalle r: rolesDetalle) {
                            try {
                                switch (r.getRoles().getIdRole()) {
                                    case 1:
                                        rolSeguridad = true;
                                        break;
                                    case 2:
                                        rolProyecto = true;
                                        break;
                                    case 3:
                                        rolDesarrollo = true;
                                        break;
                                    default:
                                        rolInvalido = true;
                                        break;

                                }
                            }catch(Exception e){
                                mav.setViewName("paginaLogin");
                                mav.addObject("registoIncorrecto", "El usuario "+ nombre+" no tiene un rol asignado");
                            }
                        //nombre=  r.getUser().getNombre()+" "+r.getUser().getApellido();

                    }

                    if(rolSeguridad && rolProyecto && rolDesarrollo){
                        mav.setViewName("bienvenido");
                        return mav.addObject("laBienvenida", nombre);
                    }else if (rolDesarrollo && rolProyecto) {
                        mav.setViewName("bienvenido_desarrollo_proyecto");
                        return mav.addObject("laBienvenida", nombre);
                    }else if(rolDesarrollo && rolSeguridad) {
                        mav.setViewName("bienvenido_desarrollo_seguridad");
                        return mav.addObject("laBienvenida", nombre);
                    }else if(rolProyecto && rolSeguridad){
                        mav.setViewName("bienvenido_proyecto_seguridad");
                        return mav.addObject("laBienvenida", nombre);
                    }else if(rolSeguridad){
                        mav.setViewName("bienvenido_seguridad");
                        return mav.addObject("laBienvenida", nombre);
                    }else if(rolProyecto){
                        mav.setViewName("bienvenido_proyecto");
                        return mav.addObject("laBienvenida", nombre);
                    }else if(rolDesarrollo){
                        mav.setViewName("bienvenido_desarrollo");
                        return mav.addObject("laBienvenida", nombre);
                    }else if (rolInvalido) {
                        mav.setViewName("paginaLogin");
                        mav.addObject("registoIncorrecto", "El usuario " + nombre + " no dispone de un rol valido");
                    }
                } else  {
                    mav.setViewName("paginaLogin");
                    mav.addObject("registoIncorrecto", "El usuario y/o la contraseña no corresponden");
                }


        } catch (Exception ex) {
            ex.printStackTrace();
            return mav;
        }


        return mav;
    }

}