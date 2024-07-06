package com.example.proyecto.web.transporte.guia_remision;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

import com.example.proyecto.web.transporte.empleados.Empleados;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="guia_remision")
public class GuiaRemision {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //INCREMENTAL
    private int id;

    private String NumFactura;
    private String PuntoPartida;
    private String PuntoLlegada;
    private String Destinatario;
    private String DocumentoDestinatario;
    private String Proveedor;
    private String DocumentoProveedor;
    private String MotivoTraslado;
    private String ModalidadTraslado;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    private Date FechaEmision;

    @Temporal(TemporalType.TIME)
    @DateTimeFormat(iso = ISO.TIME)
    private Date HoraEmision;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    private Date FechaTraslado;

    private String NumeroPedido;
    private String RazonSocialTransportista;
    private String RUCTransportista;
    private String NumeroMTC;
    private String NumeroPlaca;
    private String IdProducto;
    private String CodigoProducto;
    private String DescripcionProducto;
    private int CantidadProducto;
    private String UnidadMedida;
    private float PesoProducto;
    private String Observacion;
    @Column(columnDefinition = "ENUM('PEND', 'ENC', 'CONC', 'RECH')")
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "id_empleado", referencedColumnName = "id", nullable = true)
    private Empleados empleados;

}

