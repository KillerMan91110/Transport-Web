package com.example.proyecto.web.transporte.dto;

import lombok.Data;

@Data
public class ContactCreate {
    private String nombre;
    private String email;
    private String telefono;
    private String mensaje;
}
