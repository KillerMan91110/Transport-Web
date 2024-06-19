package com.example.proyecto.web.transporte.carretas;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarretas extends CrudRepository<Carretas, Integer>{
    @Query(value="SELECT * FROM carretas "
            + "WHERE placa_carreta LIKE %?1%",nativeQuery = true)
    List<Carretas> buscarPorTodo(String dato);
}
