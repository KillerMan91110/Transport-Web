package com.example.proyecto.web.transporte.viajes;


import com.example.proyecto.web.transporte.carretas.Carretas;
import com.example.proyecto.web.transporte.clientes.Clientes;
import com.example.proyecto.web.transporte.empleados.Empleados;
import com.example.proyecto.web.transporte.tractos.Tractos;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;

@Data
@Entity
@Table(name="viajes")
public class Viajes {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Autoincremental
    private int id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date Fecha;
    private String TipoServicio;
    private String Destino;
    private String AlmacenRetiroContenedor;
    private String AlmacenDevolucionContenedor;
    private float MontoViaje;
    
   
    @ManyToOne()
    @JoinColumn(name="empleado_Id")
    private Empleados Empleados;
    
     @ManyToOne()
    @JoinColumn(name="tractos_id")
    private Tractos Tractos;
    
    @ManyToOne()
    @JoinColumn(name="carretas_id")
    private Carretas Carretas;
    
    @ManyToOne()
    @JoinColumn(name="clientes_id")
    private Clientes clientes;
    
}
