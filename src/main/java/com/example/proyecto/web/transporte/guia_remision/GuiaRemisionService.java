package com.example.proyecto.web.transporte.guia_remision;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuiaRemisionService implements IGuiaRemisionService {

    @Autowired
    private IGuiaRemision data;

    @Override
    public List<GuiaRemision> Listar() {
        return (List<GuiaRemision>) data.findAll();
    }

    @Override
    public List<GuiaRemision> ListarPorEmpleado(int id) {
        return data.buscarPorIdEmpleado(id);
    }

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
