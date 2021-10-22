package SistemaAgil_IS2.controller;

import SistemaAgil_IS2.model.Sprint;
import SistemaAgil_IS2.service.DesarrolloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/desarrollo")
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
       /* desarrolloService.actualizarSprintInicio(id_sprint);
        List<UserStorie> userStories=desarrolloService.;
        mav.addObject("usuario",usu);
        mav.setViewName("formularioAgregarUsuario");*/
        return mav;
    }

}
