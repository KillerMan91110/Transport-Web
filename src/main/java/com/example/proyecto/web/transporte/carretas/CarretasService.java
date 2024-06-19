package com.example.proyecto.web.transporte.carretas;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarretasService implements ICarretasService{
    
    @Autowired
    private ICarretas data;

    @Override
    public List<Carretas> Listar() {
        return (List<Carretas>) data.findAll();
    }

    @Override
    public Optional<Carretas> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(Carretas c) {
        data.save(c);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Carretas> Buscar(String dato) {
        return data.buscarPorTodo(dato);
    }
    
}
