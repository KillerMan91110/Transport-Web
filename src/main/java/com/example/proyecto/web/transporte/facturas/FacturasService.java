package com.example.proyecto.web.transporte.facturas;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturasService implements IFacturasService{
    
    @Autowired
    private IFacturas data;
    
    @Override
    public List<Facturas> Listar() {
        return (List<Facturas>) data.findAll();
    }

    @Override
    public Optional<Facturas> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(Facturas f) {
        data.save(f);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Facturas> Buscar(String dato) {
        return data.buscarPorTodo(dato);
    }

    @Override
    public List<Facturas> ListarOrdenAscendente() {
        return data.OrdenAscendente();
    }

    @Override
    public List<Facturas> ListarOrdenDescendente() {
        return data.OrdenDescendente();
    }
    
}
