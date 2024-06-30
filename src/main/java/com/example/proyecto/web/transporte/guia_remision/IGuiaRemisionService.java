package com.example.proyecto.web.transporte.guia_remision;

import java.util.List;
import java.util.Optional;

public interface IGuiaRemisionService {

    // Retorna todas las guías de remisión almacenadas
    public List<GuiaRemision> Listar();


    List<GuiaRemision> ListarPorEmpleado(int id);


    public Optional<GuiaRemision> ConsultarId(int id);


    public void Guardar(GuiaRemision f);

    // Elimina una guía de remisión por su ID
    public void Eliminar(int id);


    public List<GuiaRemision> Buscar(String dato);


    public List<GuiaRemision> ListarOrdenAscendente();

    public List<GuiaRemision> ListarOrdenDescendente();
}
