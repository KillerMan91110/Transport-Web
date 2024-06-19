package com.example.proyecto.web.transporte.empleados;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleados extends CrudRepository<Empleados,Integer>{
    
    @Query(value="SELECT * FROM empleados "
            + "WHERE dni LIKE %?1% "
            + "OR nombre LIKE %?1% "
            + "OR num_licencia LIKE %?1%",nativeQuery = true)
    List<Empleados> buscarPorTodo(String dato);
    
     
   

  

}
