package com.example.proyecto.web.transporte.guia_remision;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository  //Anotación de Spring que indica que esta interfaz sirve como un repositorio de datos,
// permitiendo la manipulación y acceso a la entidad GuiaRemision.
public interface IGuiaRemision extends CrudRepository<GuiaRemision, Integer> {

    // Método personalizado para buscar guías de remisión que coincidan con un criterio específico

    //@uery -> se utiliza para especificar consultas personalizadas en SQL (nativas o JPQL)
    @Query(value="SELECT * FROM guia_remision "
            + "WHERE num_factura LIKE %?1% "
            + "OR fecha_emision LIKE %?1% "
            + "OR nom_proveedor LIKE %?1%", nativeQuery = true)
    List<GuiaRemision> buscarPorTodo(String dato);

    // Método personalizado para buscar guías de remisión asociadas a un empleado específico por su ID
    @Query(value = "SELECT * FROM guia_remision "
            + "WHERE id_empleado = ?1", nativeQuery = true)
    List<GuiaRemision> buscarPorIdEmpleado(int id);

    // Método personalizado para obtener todas las guías de remisión ordenadas por fecha de emisión ascendente
    @Query(value="SELECT * FROM guia_remision ORDER BY fecha_emision ASC", nativeQuery=true)
    List<GuiaRemision> OrdenAscendente();

    // Método personalizado para obtener todas las guías de remisión ordenadas por fecha de emisión descendente
    @Query(value="SELECT * FROM guia_remision ORDER BY fecha_emision DESC", nativeQuery=true)
    List<GuiaRemision> OrdenDescendente();
}
