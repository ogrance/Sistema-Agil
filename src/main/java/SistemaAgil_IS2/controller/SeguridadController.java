package SistemaAgil_IS2.controller;

import SistemaAgil_IS2.model.Roles;
import SistemaAgil_IS2.model.RolesDetalle;
import SistemaAgil_IS2.model.Usuario;
import SistemaAgil_IS2.model.UsuarioRol;
import SistemaAgil_IS2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
    public ModelAndView muestraFormularioAgregar()  {
        ModelAndView mav=new ModelAndView("formularioAgregarUsuario");
        mav.addObject("usuario", new Usuario());
        return mav;
    }

    @PostMapping(value = "/inserta_usuario")
    public String insertaUsuarioBD(@ModelAttribute("usuario")Usuario user) throws Exception {
        usuarioService.insertarUsuario(user);
        return "redirect:/seguridad/usuarios";
    }
    @GetMapping("/formulario-actualizar-usuario")
    public ModelAndView muestraFormularioActualizar(@RequestParam("idUsuario") Integer idUsuario) throws Exception {
        ModelAndView mav=new ModelAndView();
        Usuario usu=usuarioService.obtenerUsuarioPorId(idUsuario);
        mav.addObject("usuario",usu);
        mav.setViewName("formularioAgregarUsuario");
        return mav;
    }
    @GetMapping("/formulario-asignar-rol")
    public ModelAndView muestraFormularioAsignarRoles(@RequestParam("idUsuario") Integer idUsuario) throws Exception{
        ModelAndView mav=new ModelAndView("formularioAsignarRoles");
        Usuario user= usuarioService.obtenerUsuarioPorId(idUsuario);
        List<Roles> rol= usuarioService.obtenerRoles();
       // Set <Roles> set =new HashSet<Roles>(rol);

        RolesDetalle detalle= new RolesDetalle(rol, user,new Roles());
        System.out.println(Arrays.asList(rol));
        mav.addObject("listaRolesDetalle",detalle);
        return mav;
    }
    @RequestMapping(value = "/asignar-rol",method = RequestMethod.GET)
    public ModelAndView  asignarRolUsuarioBD(@RequestParam("idRole") Integer roleId,@RequestParam("idUsuario") Integer idUsuario) throws Exception {
        ModelAndView mav = new ModelAndView("vistaRoles");
        System.out.println("Recibimos de Front"+"Id Role: "+roleId+" "+"Id Usuario: "+idUsuario);
        try{
            usuarioService.asignarRol(idUsuario, roleId);
        }catch(DuplicateKeyException e){

            mav.addObject("ErrorKeyDuplicada", "Se esta intentando asignar un rol que ya pertenecia al Usuario");
        }

        List<RolesDetalle> rolesDetalles = usuarioService.obtenerUsuarioYRol(idUsuario);
        mav.addObject("rolesDetalles",rolesDetalles);
        return mav;
        //return "redirect:/seguridad/roles-usuarios";
    }
    /*@RequestMapping(value = "/roles-usuarios",method = RequestMethod.GET)
    public ModelAndView muestraRolesDeUsuarios() {
        ModelAndView mav = new ModelAndView("vistaRoles");

        try {
            List<RolesDetalle> rolesDetalles = usuarioService.obtenerUsuarioYRol(3);
            mav.addObject("rolesDetalles",rolesDetalles);
        } catch (Exception e){
            e.printStackTrace();
        }
        return mav;
    }*/

}
