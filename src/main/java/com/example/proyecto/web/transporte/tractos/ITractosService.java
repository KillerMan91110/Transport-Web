package com.example.proyecto.web.transporte.tractos;

import java.util.List;
import java.util.Optional;

public interface ITractosService {
    public List<Tractos> Listar();
    public Optional<Tractos> ConsultarId(int id);
    public void Guardar(Tractos t);
    public void Eliminar(int id);
    public List<Tractos> Buscar(String dato);
}
