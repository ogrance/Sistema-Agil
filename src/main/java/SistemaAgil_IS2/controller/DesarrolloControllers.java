package SistemaAgil_IS2.controller;

import SistemaAgil_IS2.model.Sprint;
import SistemaAgil_IS2.model.UserStorie;
import SistemaAgil_IS2.service.DesarrolloService;
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
    @GetMapping(value = "/redirect-gestion-sprints")
    public ModelAndView muestraGestionSprintsRedirect(@RequestParam("param") String param) {
        ModelAndView mav = new ModelAndView("listaSprintsDisponibles");

        try {

            List<Sprint> listaSprintsDisponibles = desarrolloService.obtenerSprintDisponibles();
            mav.addObject("listaSprintsDisponibles",listaSprintsDisponibles);
            if(param.equals("Inicio Correcto")) {
                mav.addObject("inicioCorrecto", "Sprint Inicializado Correctamente");
            }
            if (param.equals("Inicio Incorrecto")){
                mav.addObject("inicioRepetido", "El Sprint ya fue inicializado anteriormente");
            }
            if (param.equals("fin-correcto")){
                mav.addObject("finCorrecto", "El Sprint fue finalizado correctamente");
            }
            if(param.equals("incorrecto")){
                mav.addObject("finInCorrecto", "El Sprint ya fue finalizado anteriormente");

            }
            if(param.equals("incorrecto-noIniciado")){
                mav.addObject("finIncorrecto", "El Sprint aun no fue inicializado");

            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return mav;
    }
    @GetMapping("/iniciar-sprints")
    public ModelAndView iniciarSprints(@RequestParam("project_id") Integer project_id, @RequestParam("id_sprint") Integer id_sprint) throws Exception {
        ModelAndView mav=new ModelAndView("redirect:/gestion-sprints");
        String param;
        if(desarrolloService.verificarEstadoSprint(id_sprint).equals("TO-DO")){
            desarrolloService.actualizarSprint(id_sprint,"DOING");

             param="Inicio Correcto";
            mav.addObject("param",param);
        }else if(desarrolloService.verificarEstadoSprint(id_sprint).equals("DONE")){
           param="Inicio Incorrecto";
            mav.addObject("param",param);

        }


        return mav;
    }
    @GetMapping("/actualizar-user-stories")
    public ModelAndView actualizarUserStories(@RequestParam("project_id") Integer project_id, @RequestParam("id_sprint") Integer id_sprint) throws Exception {
        ModelAndView mav=new ModelAndView();
        //desarrolloService.actualizarSprintInicio(id_sprint);
        List<UserStorie> userStories=desarrolloService.obtenerUserStoriesPorProyecto(project_id,id_sprint);
        mav.addObject("listaUserStorieProyect",userStories);
        mav.setViewName("listaActualizarUserStories");
        return mav;
    }

    @GetMapping("/finalizar-sprint")
    public ModelAndView finalizarSprint (@RequestParam("project_id") Integer project_id, @RequestParam("id_sprint") Integer id_sprint)  throws Exception {
        ModelAndView mav=new ModelAndView("redirect:/redirect-gestion-sprints");

        if(desarrolloService.verificarEstadoSprint(id_sprint).equals("DOING") && desarrolloService.obtenerUSPendientes(project_id,id_sprint)){
            desarrolloService.actualizarSprint(id_sprint,"DONE");

            String param="fin-correcto";
            mav.addObject("param",param);
        }
        if(desarrolloService.verificarEstadoSprint(id_sprint).equals("TO-DO")|| !desarrolloService.obtenerUSPendientes(project_id, id_sprint)){
            String param="incorrecto";
            mav.addObject("param",param);
        }

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
