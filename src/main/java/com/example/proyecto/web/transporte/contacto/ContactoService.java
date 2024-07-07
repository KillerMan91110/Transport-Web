package com.example.proyecto.web.transporte.contacto;

import com.example.proyecto.web.transporte.dto.ContactDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactoService implements IContactoService{
    private final IContacto repository;
    @Override
    public List<Contacto> obtenerContactos() {
        return repository.findAllByOrder();
    }

    @Override
    public void save(ContactDto contacto) {

        repository.save(Contacto.builder()
                        .nombre(contacto.getNombre())
                        .email(contacto.getEmail())
                        .telefono(contacto.getTelefono())
                        .mensaje(contacto.getMensaje())
                .build());
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
