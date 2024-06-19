package com.example.proyecto.web.transporte.facturas;

import java.util.List;
import java.util.Optional;

public interface IFacturasService {
    public List<Facturas> Listar();
    public Optional<Facturas> ConsultarId(int id);
    public void Guardar(Facturas f);
    public void Eliminar(int id);
    public List<Facturas> Buscar(String dato);
    public List<Facturas> ListarOrdenAscendente();
    public List<Facturas> ListarOrdenDescendente();
}
 