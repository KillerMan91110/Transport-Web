package com.example.proyecto.web.transporte.contacto;

import com.example.proyecto.web.transporte.dto.ContactCreate;

import java.util.List;

public interface IContactoService {
    List<Contacto> obtenerContactos();
    void save(ContactCreate contacto);

    void delete(int id);

    void deleteAll();
}
