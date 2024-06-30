package com.example.proyecto.web.transporte.guia_remision;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGuiaRemision extends CrudRepository<GuiaRemision, Integer>{
    @Query(value="SELECT * FROM guia_remision "
            + "WHERE num_factura LIKE %?1% "
            + "OR fecha_emision LIKE %?1% "           
            + "OR nom_proveedor LIKE %?1%",nativeQuery = true)
    List<GuiaRemision> buscarPorTodo(String dato);

    @Query(value = "SELECT * FROM guia_remision "
            + "WHERE id_empleado = ?1"
            , nativeQuery = true)
    List<GuiaRemision> buscarPorIdEmpleado(int id);
    
    @Query(value="SELECT * FROM guia_remision ORDER BY fecha_emision ASC",nativeQuery=true)
    List<GuiaRemision> OrdenAscendente();
    
    @Query(value="SELECT * FROM facturas ORDER BY fecha_emision DESC",nativeQuery=true)
    List<GuiaRemision> OrdenDescendente();
}
