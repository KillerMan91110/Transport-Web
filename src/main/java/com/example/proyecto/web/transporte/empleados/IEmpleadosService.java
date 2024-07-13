package com.example.proyecto.web.transporte.empleados;

import java.util.List;
import java.util.Optional;

public interface IEmpleadosService {
    public List<Empleados> Listar();
    public Optional<Empleados> ConsultarId(int id);
    Optional<Empleados> consultarUsername(String username);
    Optional<Empleados> buscarPorNumeroLicencia(String num_licencia);
    public void Guardar(Empleados e);
    public void Eliminar(int id);
    public List<Empleados> Buscar(String dato);

}
