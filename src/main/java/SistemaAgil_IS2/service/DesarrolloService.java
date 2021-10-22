package SistemaAgil_IS2.service;

import SistemaAgil_IS2.model.Sprint;

import java.util.List;

public interface DesarrolloService {
    List<Sprint> obtenerSprintDisponibles() throws Exception;
    void actualizarSprintInicio(Integer sprintId) throws Exception;
}
