package SistemaAgil_IS2_war.controller;

import SistemaAgil_IS2_war.model.Sprint;
import SistemaAgil_IS2_war.model.UserStorie;
import SistemaAgil_IS2_war.service.DesarrolloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class DesarrolloControllers {
    @Autowired
    DesarrolloService desarrolloService;
    @RequestMapping(value = "/gestion-sprints",method = RequestMethod.GET)
    public ModelAndView muestraGestionSprints() {
        ModelAndView mav = new ModelAndView("listaSprintsDisponibles");

        try {

            List<Sprint> listaSprintsDisponibles = desarrolloService.obtenerSprintDisponibles();
            mav.addObject("listaSprintsDisponibles",listaSprintsDisponibles);
        } catch (Exception e){
            e.printStackTrace();
        }
        return mav;
    }
    @GetMapping("/actualizar-user-stories")
    public ModelAndView actualizarUserStories(@RequestParam("project_id") Integer project_id, @RequestParam("id_sprint") Integer id_sprint) throws Exception {
        ModelAndView mav=new ModelAndView();
        desarrolloService.actualizarSprintInicio(id_sprint);
        List<UserStorie> userStories=desarrolloService.obtenerUserStoriesPorProyecto(project_id,id_sprint);
        mav.addObject("listaUserStorieProyect",userStories);
        mav.setViewName("listaActualizarUserStories");
        return mav;
    }

    @GetMapping("/finalizar-sprint")
    public ModelAndView finalizarSprint( @RequestParam("id_sprint") Integer id_sprint) throws Exception {
        ModelAndView mav=new ModelAndView();
               /* desarrolloService.actualizarSprintInicio(id_sprint);
        List<UserStorie> userStories=desarrolloService.;
        mav.addObject("usuario",usu);
        mav.setViewName("formularioAgregarUsuario");*/
        return mav;
    }

    @RequestMapping("/modificar-user-stories")
    public String modificaUserStories(Model model){
        UserStorie us=new UserStorie();
        model.addAttribute("userStories",us);

        return "cambiarEstadoUserStories";
    }
    @RequestMapping("/procesarUS")
    public String procesarUS(@ModelAttribute("userStories") UserStorie us) throws Exception {
       desarrolloService.actualizarEstadoUS(us.getEstatus(),us.getId_us());
      return "redirect:/actualizar-user-stories";
    }
}
