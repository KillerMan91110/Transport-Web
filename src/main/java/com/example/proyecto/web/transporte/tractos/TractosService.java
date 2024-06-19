package com.example.proyecto.web.transporte.tractos;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TractosService implements ITractosService{
    @Autowired
    private ITractos data;

    @Override
    public List<Tractos> Listar(){
        return (List<Tractos>) data.findAll();
    }

    @Override
    public Optional<Tractos> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(Tractos t) {
        data.save(t);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Tractos> Buscar(String dato) {
        return data.buscarPorTodo(dato);
    }
    
    
}
