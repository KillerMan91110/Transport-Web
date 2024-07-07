package com.example.proyecto.web.transporte.guia_remision;

import com.example.proyecto.web.transporte.dto.GuiaRemisionDto;

import java.util.List;
import java.util.Optional;

public interface IGuiaRemisionService {
    public List<GuiaRemision> Listar();
    List<GuiaRemision> ListarPorEmpleado(int id);
    public GuiaRemisionDto ConsultarId(int id);

    void GuardarDto(GuiaRemisionDto guiaRemision);
    void actualizar(int id, GuiaRemisionDto guiaRemisionDto);
    public void Guardar(GuiaRemision guiaRemision);
    boolean actualizarEstadoGuia(int id, String estado);
    public void Eliminar(int id);
    public List<GuiaRemision> Buscar(String dato);
    public List<GuiaRemision> ListarOrdenAscendente();
    public List<GuiaRemision> ListarOrdenDescendente();
}
