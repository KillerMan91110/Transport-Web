package com.example.proyecto.web.transporte.facturas;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Data
@Entity
@Table(name="facturas")
public class Facturas {
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Autoincremental
    private int id;
    //private int NumOrden;
    private String NumFactura;
    private String NomProveedor;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    private Date FechaEmision;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    private Date FechaRecepcion;
    //private float MontoSoles;
    //private float MontoDolares;
    private String TipoMoneda;
    private float Monto;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    private Date FechaPagoDetraccion;
    private float DepositoDetraccion;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    private Date FechaPago;
    private String Observacion;
}
