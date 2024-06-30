package com.example.proyecto.web.transporte.contacto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@Entity
@Table(name = "contacto")
@AllArgsConstructor
public class Contacto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //Autoincremental
    @Column(name = "id")
    private int id;
    private String nombre;
    private String email;
    private String telefono;
    private String mensaje;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createDate;

    @PrePersist
    private void onCreate() {
        createDate = new Date();
    }
}
