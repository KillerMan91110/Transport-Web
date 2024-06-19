package com.example.proyecto.web.transporte.empleados;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadosService implements IEmpleadosService{
    @Autowired
    private IEmpleados data;
    
    @Override
    public List<Empleados> Listar() {
        return (List<Empleados>) data.findAll();
    }

    @Override
    public Optional<Empleados> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(Empleados a) {
        data.save(a);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Empleados> Buscar(String dato) {
        return data.buscarPorTodo(dato);
    }

}
