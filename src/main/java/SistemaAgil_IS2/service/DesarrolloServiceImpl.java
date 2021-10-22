package SistemaAgil_IS2.service;

import SistemaAgil_IS2.dao.DesarrolloDao;
import SistemaAgil_IS2.model.Sprint;
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
    public void actualizarSprintInicio(Integer sprintId) throws Exception {
        desarrolloDao.actualizarSprintInicio(sprintId);
    }

}
