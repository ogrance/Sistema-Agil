package SistemaAgil_IS2_war.service;

import SistemaAgil_IS2_war.model.Sprint;
import SistemaAgil_IS2_war.model.UserStorie;

import java.util.List;

public interface DesarrolloService {
    List<Sprint> obtenerSprintDisponibles() throws Exception;
    void actualizarSprintInicio(Integer sprintId) throws Exception;
    List<UserStorie> obtenerUserStoriesPorProyecto(Integer idProyecto, Integer idSprint) throws Exception;
    void actualizarEstadoUS(String estado,Integer idUs) throws Exception;
}
