package SistemaAgil_IS2.service;

import SistemaAgil_IS2.model.Sprint;
import SistemaAgil_IS2.model.UserStorie;

import java.util.List;

public interface DesarrolloService {
    List<Sprint> obtenerSprintDisponibles() throws Exception;
    void actualizarSprint(Integer sprintId,String estatus) throws Exception;
    List<UserStorie> obtenerUserStoriesPorProyecto(Integer idProyecto, Integer idSprint) throws Exception;
    void actualizarEstadoUS(String estado,Integer idUs) throws Exception;
    String verificarEstadoSprint(Integer idSprint) throws Exception;
    boolean obtenerUSPendientes(Integer idProyecto, Integer idSprint);
}
