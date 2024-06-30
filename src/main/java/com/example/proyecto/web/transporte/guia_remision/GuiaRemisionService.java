package com.example.proyecto.web.transporte.guia_remision;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuiaRemisionService implements IGuiaRemisionService {

    @Autowired
    private IGuiaRemision data; // Inyección de dependencia del repositorio IGuiaRemision

    //@Override están sobrescribiendo métodos de la interfaz IGuiaRemisionService
    // Método para listar todas las guías de remisión
    @Override
    public List<GuiaRemision> Listar() {
        return (List<GuiaRemision>) data.findAll();
    }

    // Método para listar las guías de remisión asociadas a un empleado específico por su ID
    @Override
    public List<GuiaRemision> ListarPorEmpleado(int id) {
        return data.buscarPorIdEmpleado(id);
    }

    // Método para consultar una guía de remisión por su ID
    @Override
    public Optional<GuiaRemision> ConsultarId(int id) {
        return data.findById(id);
    }

    // Método para guardar una nueva guía de remisión o actualizar una existente
    @Override
    public void Guardar(GuiaRemision f) {
        data.save(f);
    }

    // Método para eliminar una guía de remisión por su ID
    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    // Método para buscar guías de remisión que coincidan con un criterio específico
    @Override
    public List<GuiaRemision> Buscar(String dato) {
        return data.buscarPorTodo(dato);
    }

    // Métodos para listar todas las guías de remisión en orden ascendente y descendente
    @Override
    public List<GuiaRemision> ListarOrdenAscendente() {
        return data.OrdenAscendente();
    }

    @Override
    public List<GuiaRemision> ListarOrdenDescendente() {
        return data.OrdenDescendente();
    }
}
