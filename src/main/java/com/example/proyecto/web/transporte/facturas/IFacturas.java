package com.example.proyecto.web.transporte.facturas;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacturas extends CrudRepository<Facturas, Integer>{
    @Query(value="SELECT * FROM facturas "
            + "WHERE num_factura LIKE %?1% "
            + "OR fecha_emision LIKE %?1% "           
            + "OR nom_proveedor LIKE %?1%",nativeQuery = true)
    List<Facturas> buscarPorTodo(String dato);
    
    @Query(value="SELECT * FROM facturas ORDER BY fecha_emision ASC",nativeQuery=true)
    List<Facturas> OrdenAscendente();
    
    @Query(value="SELECT * FROM facturas ORDER BY fecha_emision DESC",nativeQuery=true)
    List<Facturas> OrdenDescendente();
}
