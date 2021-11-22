package SistemaAgil_IS2.service;

import SistemaAgil_IS2.dao.DesarrolloDao;
import SistemaAgil_IS2.model.Sprint;
import SistemaAgil_IS2.model.UserStorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DesarrolloServiceImpl implements DesarrolloService{
    @Autowired
    DesarrolloDao desarrolloDao;
    @Override
    public List<Sprint> obtenerSprintDisponibles() throws Exception {
        return desarrolloDao.mostrarSprintsDisponibles();
    }

    @Override
    public void actualizarSprint(Integer sprintId,String estatus) throws Exception {
        desarrolloDao.actualizarSprint(sprintId,estatus);
    }



    @Override
    public List<UserStorie> obtenerUserStoriesPorProyecto(Integer idProyecto, Integer idSprint) throws Exception {
        return desarrolloDao.obtenerUserStoriesPorProyecto(idProyecto,idSprint);
    }

    @Override
    public void actualizarEstadoUS(String estado, Integer idUs) throws Exception {
        desarrolloDao.actualizarEstadoUS(estado, idUs);
    }

    @Override
    public String verificarEstadoSprint(Integer idSprint) throws Exception {
        return desarrolloDao.verificarEstadoSprint(idSprint);
    }

    @Override
    public boolean obtenerUSPendientes(Integer idProyecto, Integer idSprint) {
        boolean ret= desarrolloDao.obtenerUSPendientes(idProyecto,idSprint)==0;
        return ret;
    }

}
