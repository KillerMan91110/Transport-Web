package com.example.proyecto.web.transporte.carretas;

import java.util.List;
import java.util.Optional;

public interface ICarretasService {
     public List<Carretas> Listar();
    public Optional<Carretas> ConsultarId(int id);
    public void Guardar(Carretas c);
    public void Eliminar(int id);
    public List<Carretas> Buscar(String dato);
}
