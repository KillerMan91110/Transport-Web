package com.example.proyecto.web.transporte.carretas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="carretas")
public class Carretas {
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Autoincremental
     private int id;
     private String PlacaCarreta;
     private String Peso;
     private String Largo;
     private String Ancho;
}
