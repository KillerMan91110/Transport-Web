
package com.example.proyecto.web.transporte.clientes;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientes extends CrudRepository<Clientes, Integer>{
   @Query(value="SELECT * FROM clientes "
            + "WHERE ruc LIKE %?1% "
            + "OR nombre LIKE %?1%",nativeQuery = true)
   List<Clientes> buscarPorTodo(String dato);
}
