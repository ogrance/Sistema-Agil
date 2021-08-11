package SistemaAgil_IS2.controller;

import SistemaAgil_IS2.model.Usuario;
import SistemaAgil_IS2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/seguridad")
public class SeguridadController {
@Autowired
private UsuarioService usuarioService;

    @RequestMapping(value = "inicio_seguridad",method = RequestMethod.GET)
    public ModelAndView mostrarPaginaSeguridad(){
        ModelAndView mav=new ModelAndView("paginaSeguridad");
        mav.addObject("modulo","Seguridad");
        return mav;
    }

    @RequestMapping(value = "/usuarios",method = RequestMethod.GET)
    public ModelAndView muestraUsuarios() {
        ModelAndView mav = new ModelAndView("listaUsuarios");

        try {
            List<Usuario> usuarios = usuarioService.obtenerListaUsuarios();
            mav.addObject("listaUsuarios",usuarios);
        } catch (Exception e){
            e.printStackTrace();
        }
        return mav;
    }
    @RequestMapping(value = "/agregar_usuario",method = RequestMethod.GET)
    public ModelAndView muestraFormularioAgregar(){
        ModelAndView mav=new ModelAndView("formularioAgregarUsuario");
        return mav;
    }

}
