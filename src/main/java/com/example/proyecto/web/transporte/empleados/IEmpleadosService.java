package com.example.proyecto.web.transporte.empleados;

import java.util.List;
import java.util.Optional;

public interface IEmpleadosService {
    public List<Empleados> Listar();
    public Optional<Empleados> ConsultarId(int id);
    public void Guardar(Empleados e);
    public void Eliminar(int id);
    public List<Empleados> Buscar(String dato);
    /*public List<Empleados> ListarOrdenAscendente();
    public List<Empleados> ListarOrdenDescendente();
    public float Suma();
    public int Total();
    public List<Empleados> ListaCosto();*/
}
