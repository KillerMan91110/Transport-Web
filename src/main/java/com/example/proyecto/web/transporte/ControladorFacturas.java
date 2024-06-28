package com.example.proyecto.web.transporte;

import com.example.proyecto.web.transporte.facturas.Facturas;
import com.example.proyecto.web.transporte.facturas.IFacturasService;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorFacturas {

    @Autowired
    private IFacturasService serviceFacturas;

    @GetMapping("/listadoFacturas")
    public String Mostrar(Model model) {
        List<Facturas> facturas = serviceFacturas.Listar();
        model.addAttribute("facturas", facturas);
        return "facturas/listadoFacturas";
    }

    @GetMapping("/eliminarFactura")
    public String Eliminar(@RequestParam("id") int id, Model model) {
        serviceFacturas.Eliminar(id);
        return "redirect:/listadoFacturas";
    }

    @GetMapping("/registroFacturas")
    public String registroFacturas() {
        return "facturas/registroFacturas";
    }

    @PostMapping("/registroFacturas")
    public String Registrar(
            @RequestParam("Num_Factura") String NumFactura,
            @RequestParam("PuntoPartida") String PuntoPartida,
            @RequestParam("PuntoLlegada") String PuntoLlegada,
            @RequestParam("Destinatario") String Destinatario,
            @RequestParam("DocumentoDestinatario") String DocumentoDestinatario,
            @RequestParam("Proveedor") String Proveedor,
            @RequestParam("DocumentoProveedor") String DocumentoProveedor,
            @RequestParam("MotivoTraslado") String MotivoTraslado,
            @RequestParam("ModalidadTraslado") String ModalidadTraslado,
            @RequestParam("FechaEmision") @DateTimeFormat(pattern = "yyyy-MM-dd") Date FechaEmision,
            @RequestParam("HoraEmision") @DateTimeFormat(pattern = "HH:mm") Date HoraEmision,
            @RequestParam("FechaTraslado") @DateTimeFormat(pattern = "yyyy-MM-dd") Date FechaTraslado,
            @RequestParam("NumeroPedido") String NumeroPedido,
            @RequestParam("RazonSocialTransportista") String RazonSocialTransportista,
            @RequestParam("RUCTransportista") String RUCTransportista,
            @RequestParam("NumeroMTC") String NumeroMTC,
            @RequestParam("Conductor") String Conductor,
            @RequestParam("DocumentoConductor") String DocumentoConductor,
            @RequestParam("NumeroLicencia") String NumeroLicencia,
            @RequestParam("NumeroPlaca") String NumeroPlaca,
            @RequestParam("IdProducto") String IdProducto,
            @RequestParam("CodigoProducto") String CodigoProducto,
            @RequestParam("DescripcionProducto") String DescripcionProducto,
            @RequestParam("CantidadProducto") int CantidadProducto,
            @RequestParam("UnidadMedida") String UnidadMedida,
            @RequestParam("PesoProducto") float PesoProducto,
            @RequestParam("Observacion") String Observacion,
            Model model) throws ParseException {

        Facturas f = new Facturas();
        f.setNumFactura(NumFactura);
        f.setPuntoPartida(PuntoPartida);
        f.setPuntoLlegada(PuntoLlegada);
        f.setDestinatario(Destinatario);
        f.setDocumentoDestinatario(DocumentoDestinatario);
        f.setProveedor(Proveedor);
        f.setDocumentoProveedor(DocumentoProveedor);
        f.setMotivoTraslado(MotivoTraslado);
        f.setModalidadTraslado(ModalidadTraslado);
        f.setFechaEmision(FechaEmision);
        f.setHoraEmision(HoraEmision);
        f.setFechaTraslado(FechaTraslado);
        f.setNumeroPedido(NumeroPedido);
        f.setRazonSocialTransportista(RazonSocialTransportista);
        f.setRUCTransportista(RUCTransportista);
        f.setNumeroMTC(NumeroMTC);
        f.setConductor(Conductor);
        f.setDocumentoConductor(DocumentoConductor);
        f.setNumeroLicencia(NumeroLicencia);
        f.setNumeroPlaca(NumeroPlaca);
        f.setIdProducto(IdProducto);
        f.setCodigoProducto(CodigoProducto);
        f.setDescripcionProducto(DescripcionProducto);
        f.setCantidadProducto(CantidadProducto);
        f.setUnidadMedida(UnidadMedida);
        f.setPesoProducto(PesoProducto);
        f.setObservacion(Observacion);

        serviceFacturas.Guardar(f);
        return "redirect:/listadoFacturas";
    }

    @PostMapping("/actualizarFacturas")
    public String Actualizar(
            @RequestParam("id") int id,
            @RequestParam("Num_Factura") String NumFactura,
            @RequestParam("PuntoPartida") String PuntoPartida,
            @RequestParam("PuntoLlegada") String PuntoLlegada,
            @RequestParam("Destinatario") String Destinatario,
            @RequestParam("DocumentoDestinatario") String DocumentoDestinatario,
            @RequestParam("Proveedor") String Proveedor,
            @RequestParam("DocumentoProveedor") String DocumentoProveedor,
            @RequestParam("MotivoTraslado") String MotivoTraslado,
            @RequestParam("ModalidadTraslado") String ModalidadTraslado,
            @RequestParam("FechaEmision") @DateTimeFormat(pattern = "yyyy-MM-dd") Date FechaEmision,
            @RequestParam("HoraEmision") @DateTimeFormat(pattern = "HH:mm") Date HoraEmision,
            @RequestParam("FechaTraslado") @DateTimeFormat(pattern = "yyyy-MM-dd") Date FechaTraslado,
            @RequestParam("NumeroPedido") String NumeroPedido,
            @RequestParam("RazonSocialTransportista") String RazonSocialTransportista,
            @RequestParam("RUCTransportista") String RUCTransportista,
            @RequestParam("NumeroMTC") String NumeroMTC,
            @RequestParam("Conductor") String Conductor,
            @RequestParam("DocumentoConductor") String DocumentoConductor,
            @RequestParam("NumeroLicencia") String NumeroLicencia,
            @RequestParam("NumeroPlaca") String NumeroPlaca,
            @RequestParam("IdProducto") String IdProducto,
            @RequestParam("CodigoProducto") String CodigoProducto,
            @RequestParam("DescripcionProducto") String DescripcionProducto,
            @RequestParam("CantidadProducto") int CantidadProducto,
            @RequestParam("UnidadMedida") String UnidadMedida,
            @RequestParam("PesoProducto") float PesoProducto,
            @RequestParam("Observacion") String Observacion,
            Model model) {

        Facturas f = new Facturas();
        f.setId(id);
        f.setNumFactura(NumFactura);
        f.setPuntoPartida(PuntoPartida);
        f.setPuntoLlegada(PuntoLlegada);
        f.setDestinatario(Destinatario);
        f.setDocumentoDestinatario(DocumentoDestinatario);
        f.setProveedor(Proveedor);
        f.setDocumentoProveedor(DocumentoProveedor);
        f.setMotivoTraslado(MotivoTraslado);
        f.setModalidadTraslado(ModalidadTraslado);
        f.setFechaEmision(FechaEmision);
        f.setHoraEmision(HoraEmision);
        f.setFechaTraslado(FechaTraslado);
        f.setNumeroPedido(NumeroPedido);
        f.setRazonSocialTransportista(RazonSocialTransportista);
        f.setRUCTransportista(RUCTransportista);
        f.setNumeroMTC(NumeroMTC);
        f.setConductor(Conductor);
        f.setDocumentoConductor(DocumentoConductor);
        f.setNumeroLicencia(NumeroLicencia);
        f.setNumeroPlaca(NumeroPlaca);
        f.setIdProducto(IdProducto);
        f.setCodigoProducto(CodigoProducto);
        f.setDescripcionProducto(DescripcionProducto);
        f.setCantidadProducto(CantidadProducto);
        f.setUnidadMedida(UnidadMedida);
        f.setPesoProducto(PesoProducto);
        f.setObservacion(Observacion);

        serviceFacturas.Guardar(f);
        return "redirect:/listadoFacturas";
    }

    @PostMapping("/buscarFacturas")
    public String Buscar(@RequestParam("dato") String dato, Model model) {
        List<Facturas> facturas = serviceFacturas.Buscar(dato);
        model.addAttribute("facturas", facturas);
        return "facturas/listadoFacturas";
    }

    @GetMapping("/ascendente")
    public String MostrarAscendente(Model model) {
        List<Facturas> facturas = serviceFacturas.ListarOrdenAscendente();
        model.addAttribute("facturas", facturas);
        return "facturas/listadoFacturas";
    }

    @GetMapping("/descendente")
    public String MostrarDescendente(Model model) {
        List<Facturas> facturas = serviceFacturas.ListarOrdenDescendente();
        model.addAttribute("facturas", facturas);
        return "facturas/listadoFacturas";
    }
}
