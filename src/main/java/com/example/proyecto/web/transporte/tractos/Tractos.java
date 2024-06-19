package com.example.proyecto.web.transporte.tractos;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="tractos")
public class Tractos {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Autoincremental
    private int id;
    private String PlacaTracto;
    private String TipoTraccion;
    private String Potencia;
    private String Motor;
}
