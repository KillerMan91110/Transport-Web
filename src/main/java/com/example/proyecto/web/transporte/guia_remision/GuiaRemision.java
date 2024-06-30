package com.example.proyecto.web.transporte.guia_remision;

import javax.persistence.Entity;
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
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Data //Esta anotación es parte de Lombok y genera automáticamente métodos toString,
// equals, hashCode, getter y setter para todos los campos de la clase
@Entity //que está mapeada a una tabla en la base de datos.
@Table(name="guia_remision") //Especifica el nombre de la tabla en la base de datos
// donde se almacenarán las instancias de esta entidad
public class GuiaRemision {
    @Id //marca el campo id como clave prinaria
    @GeneratedValue(strategy=GenerationType.IDENTITY) // Clave primaria autoincremental
    private int id;

    private String NumFactura; // Número de factura asociado a la guía
    private String PuntoPartida; // Lugar de inicio del traslado
    private String PuntoLlegada; // Lugar de destino del traslado
    private String Destinatario; // Nombre del destinatario de la mercancía
    private String DocumentoDestinatario; // Documento de identidad del destinatario
    private String Proveedor; // Nombre del proveedor de la mercancía
    private String DocumentoProveedor; // Documento de identidad del proveedor
    private String MotivoTraslado; // Motivo o razón del traslado de la mercancía
    private String ModalidadTraslado; // Modalidad de transporte utilizada

    @Temporal(TemporalType.DATE) //: Estas anotaciones especifican el formato de los campos de fecha y hora
    @DateTimeFormat(iso = ISO.DATE)
    private Date FechaEmision; // Fecha de emisión de la guía

    @Temporal(TemporalType.TIME)
    @DateTimeFormat(iso = ISO.TIME)
    private Date HoraEmision; // Hora de emisión de la guía

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    private Date FechaTraslado; // Fecha programada para el traslado

    private String NumeroPedido; // Número de pedido asociado a la guía
    private String RazonSocialTransportista; // Razón social del transportista
    private String RUCTransportista; // RUC del transportista
    private String NumeroMTC; // Número de MTC (Método de Transporte de Carga)
    private String Conductor; // Nombre del conductor del vehículo de transporte
    private String DocumentoConductor; // Documento de identidad del conductor
    private String NumeroLicencia; // Número de licencia de conducir del conductor
    private String NumeroPlaca; // Número de placa del vehículo de transporte
    private String IdProducto; // Identificador del producto transportado
    private String CodigoProducto; // Código del producto transportado
    private String DescripcionProducto; // Descripción del producto transportado
    private int CantidadProducto; // Cantidad del producto transportado
    private String UnidadMedida; // Unidad de medida del producto transportado
    private float PesoProducto; // Peso del producto transportado
    private String Observacion; // Observaciones adicionales relacionadas con la guía

    //Define una relación many-to-one entre la entidad GuiaRemision y Empleados. Esto indica que cada GuiaRemision está asociada
    // a un empleado (Empleados), utilizando la columna id_empleado como clave foránea
    @ManyToOne
    @JoinColumn(name = "id_empleado", referencedColumnName = "id", nullable = true)
    private Empleados empleados; // Empleado asociado a esta guía de remisión
}



