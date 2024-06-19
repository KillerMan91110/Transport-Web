package com.example.proyecto.web.transporte.empleados;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="empleados")
public class Empleados {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Autoincremental

    int id;
    String dni;
    String nombre;
    String sexo;
    String num_licencia;
    String celular;
    String correo;
    String direccion;
}
