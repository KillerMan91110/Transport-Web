
package com.example.proyecto.web.transporte.clientes;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService implements IClientesService{
    
    @Autowired
    private IClientes data;

    @Override
    public List<Clientes> Listar() {
        return (List<Clientes>) data.findAll();
    }

    @Override
    public Optional<Clientes> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(Clientes cl) {
        data.save(cl);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Clientes> Buscar(String dato) {
        return data.buscarPorTodo(dato);
    }
    
    
}
