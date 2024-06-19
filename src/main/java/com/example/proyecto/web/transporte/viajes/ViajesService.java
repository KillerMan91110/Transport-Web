package com.example.proyecto.web.transporte.viajes;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViajesService implements IViajesService {

    @Autowired
    private IViajes data;

    @Override
    public List<Viajes> Listar() {
        return (List<Viajes>) data.findAll();
    }

    @Override
    public Optional<Viajes> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(Viajes v) {
        data.save(v);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Viajes> Buscar(String dato) {
        return data.buscarPorTodo(dato);
    }

    @Override
    public List<Viajes> ListarOrdenAscendente() {
        return data.OrdenAscendente();
    }

    @Override
    public List<Viajes> ListarOrdenDescendente() {
        return data.OrdenDescendente();
    }

}
