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


    @Override
    public void Guardar(GuiaRemision f) {
        data.save(f);
    }


    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }


    @Override
    public List<GuiaRemision> Buscar(String dato) {
        return data.buscarPorTodo(dato);
    }


    @Override
    public List<GuiaRemision> ListarOrdenAscendente() {
        return data.OrdenAscendente();
    }

    @Override
    public List<GuiaRemision> ListarOrdenDescendente() {
        return data.OrdenDescendente();
    }
}
