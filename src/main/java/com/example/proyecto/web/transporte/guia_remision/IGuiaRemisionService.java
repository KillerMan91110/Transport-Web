package com.example.proyecto.web.transporte.guia_remision;

import java.util.List;
import java.util.Optional;

public interface IGuiaRemisionService {
    public List<GuiaRemision> Listar();
    List<GuiaRemision> ListarPorEmpleado(int id);
    public Optional<GuiaRemision> ConsultarId(int id);
    public void Guardar(GuiaRemision f);
    public void Eliminar(int id);
    public List<GuiaRemision> Buscar(String dato);
    public List<GuiaRemision> ListarOrdenAscendente();
    public List<GuiaRemision> ListarOrdenDescendente();
}
 