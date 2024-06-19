package com.example.proyecto.web.transporte.tractos;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITractos extends CrudRepository<Tractos,Integer>{
    @Query(value="SELECT *FROM tractos "
            + "WHERE placa_tracto LIKE %?1%",nativeQuery = true)
    List<Tractos> buscarPorTodo(String dato);
}
