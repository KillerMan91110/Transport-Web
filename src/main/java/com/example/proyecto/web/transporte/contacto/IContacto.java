package com.example.proyecto.web.transporte.contacto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContacto extends JpaRepository<Contacto, Integer> {

    @Query(value = "SELECT * FROM contacto ORDER BY create_date DESC", nativeQuery = true)
    List<Contacto> findAllByOrder();
    List<Contacto> findAllByOrderByCreateDateDesc();
}