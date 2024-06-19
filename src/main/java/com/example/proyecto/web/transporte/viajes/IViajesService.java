package com.example.proyecto.web.transporte.viajes;

import java.util.List;
import java.util.Optional;

public interface IViajesService {
    public List<Viajes> Listar();
    public Optional<Viajes> ConsultarId(int id);
    public void Guardar(Viajes v);
    public void Eliminar(int id);
    public List<Viajes> Buscar(String dato);
    public List<Viajes> ListarOrdenAscendente();
    public List<Viajes> ListarOrdenDescendente();
}
