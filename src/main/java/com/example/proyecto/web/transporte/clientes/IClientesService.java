
package com.example.proyecto.web.transporte.clientes;

import java.util.List;
import java.util.Optional;

public interface IClientesService {
    public List<Clientes> Listar(); 
    public Optional<Clientes> ConsultarId(int id);
    public void Guardar(Clientes cl);
    public void Eliminar(int id);
    public List<Clientes> Buscar(String dato);
}
