package com.example.proyecto.web.transporte.dto;

import com.example.proyecto.web.transporte.guia_remision.Estado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link com.example.proyecto.web.transporte.guia_remision.GuiaRemision}
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GuiaRemisionDto implements Serializable {
    String NumFactura;
    String PuntoPartida;
    String PuntoLlegada;
    String Destinatario;
    String DocumentoDestinatario;
    String Proveedor;
    String DocumentoProveedor;
    String MotivoTraslado;
    String ModalidadTraslado;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date FechaEmision;
    @DateTimeFormat(pattern = "HH:mm")
    Date HoraEmision;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date FechaTraslado;
    String NumeroPedido;
    String RazonSocialTransportista;
    String ructransportista;
    String NumeroMTC;
    String NumeroPlaca;
    String IdProducto;
    String CodigoProducto;
    String DescripcionProducto;
    int CantidadProducto;
    String UnidadMedida;
    float PesoProducto;
    String Observacion;
    Estado estado;
    int idEmpleado;
}