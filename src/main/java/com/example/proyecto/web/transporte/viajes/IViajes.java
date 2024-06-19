package com.example.proyecto.web.transporte.viajes;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IViajes extends CrudRepository<Viajes,Integer>{
    @Query(value="SELECT * FROM viajes "
            + "WHERE tipo_servicio LIKE %?1% "
            + "OR fecha LIKE %?1% "
            + "OR destino LIKE %?1%",nativeQuery = true)
    List<Viajes> buscarPorTodo(String dato);

      @Query(value="SELECT * FROM viajes ORDER BY destino ASC",nativeQuery=true)
    List<Viajes> OrdenAscendente();
    
    @Query(value="SELECT * FROM viajes ORDER BY destino DESC",nativeQuery=true)
    List<Viajes> OrdenDescendente();

}
