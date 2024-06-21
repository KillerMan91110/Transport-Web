package com.example.proyecto.web.transporte.empleados;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEmpleados extends CrudRepository<Empleados,Integer>{
    
    @Query(value="SELECT * FROM empleados "
            + "WHERE dni LIKE %?1% "
            + "OR nombre LIKE %?1% "
            + "OR num_licencia LIKE %?1%",nativeQuery = true)
    List<Empleados> buscarPorTodo(String dato);

    @Query(value="SELECT * FROM empleados WHERE username = ?1 LIMIT 1",nativeQuery = true)
    Optional<Empleados> findByUsername(String username);

    @Query(value =
                "SELECT e.* FROM empleados e "+
                "INNER JOIN user_rol ur ON e.id = ur.id_user "+
                "INNER JOIN rol r ON ur.rol_id = r.rol_id "+
                "WHERE r.name != ?1 "
                , nativeQuery = true)
    List<Empleados> findAllNotRole(String role);
    
     
   

  

}
