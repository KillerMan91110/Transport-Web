package com.example.proyecto.web.transporte.guia_remision;

import java.util.List;
import java.util.Optional;

public interface IGuiaRemisionService {

    // Retorna todas las guías de remisión almacenadas
    public List<GuiaRemision> Listar();

    // Retorna guías de remisión asociadas a un empleado específico por su ID
    List<GuiaRemision> ListarPorEmpleado(int id);

    // Consulta una guía de remisión por su ID específico
    public Optional<GuiaRemision> ConsultarId(int id);

    // Guarda una nueva guía de remisión o actualiza una existente
    public void Guardar(GuiaRemision f);

    // Elimina una guía de remisión por su ID
    public void Eliminar(int id);

    // Realiza una búsqueda de guías de remisión que coincidan con un criterio específico
    public List<GuiaRemision> Buscar(String dato);

    // Retorna todas las guías de remisión ordenadas por fecha de emisión ascendente
    public List<GuiaRemision> ListarOrdenAscendente();

    // Retorna todas las guías de remisión ordenadas por fecha de emisión descendente
    public List<GuiaRemision> ListarOrdenDescendente();
}
