package com.example.proyecto.web.transporte.contacto;

import com.example.proyecto.web.transporte.dto.ContactDto;

import java.util.List;

public interface IContactoService {
    List<Contacto> obtenerContactos();
    void save(ContactDto contacto);

    void delete(int id);

    void deleteAll();
}
