package com.example.proyecto.web.transporte;

import com.example.proyecto.web.transporte.security.CustomUserDetails;
import com.example.proyecto.web.transporte.empleados.Empleados;
import com.example.proyecto.web.transporte.empleados.IEmpleadosService;
import com.example.proyecto.web.transporte.guia_remision.GuiaRemision;
import com.example.proyecto.web.transporte.guia_remision.IGuiaRemisionService;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ControladorGuiaRemision {

    @Autowired
    private IGuiaRemisionService serviceGuiaRemision;
    @Autowired
    private IEmpleadosService empleadoService;

    @GetMapping("/listadoGuiaRemision")
    public String Mostrar(Model model, @AuthenticationPrincipal CustomUserDetails userDetails) {
        if(userDetails != null) {
            String username = userDetails.getUsername();
            Empleados empleados = empleadoService.consultarUsername(username).orElse(null);
            assert empleados != null;
            boolean isAdmin = userDetails.getAuthorities().stream()
                    .anyMatch(auth -> auth.getAuthority().equals("ADMINISTRADOR"));
            if (isAdmin) {
                // If the user is an administrator, show all GuiaRemision
                model.addAttribute("GuiaRemision", serviceGuiaRemision.Listar());
            } else {
                // If the user is not an administrator, show GuiaRemision by Empleado
                model.addAttribute("GuiaRemision", serviceGuiaRemision.ListarPorEmpleado(empleados.getId()));
            }
        }
        return "GuiaRemision/listadoGuiaRemision";
    }

    @GetMapping("/eliminarGuiaRemision")
    public String Eliminar(@RequestParam("id") int id, Model model) {
        serviceGuiaRemision.Eliminar(id);
        return "redirect:/listadoGuiaRemision";
    }

    @GetMapping("/registroGuiaRemision")
    public String registroGuiaRemision() {
        return "GuiaRemision/registroGuiaRemision";
    }

    @PostMapping("/registroGuiaRemision")
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
            @RequestParam("CantidadProducto") int cantidad_producto,
            @RequestParam("UnidadMedida") String UnidadMedida,
            @RequestParam("PesoProducto") float peso_producto,
            @RequestParam("Observacion") String Observacion,
            Model model,
            @AuthenticationPrincipal CustomUserDetails userDetails) throws ParseException {

        if (userDetails != null) {
            String username = userDetails.getUsername();
            Optional<Empleados> empleadosOptional = empleadoService.consultarUsername(username);
            GuiaRemision f = new GuiaRemision();
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
            f.setCantidadProducto(cantidad_producto);
            f.setUnidadMedida(UnidadMedida);
            f.setPesoProducto(peso_producto);
            f.setObservacion(Observacion);
            f.setEmpleados(empleadosOptional.orElse(null));
            serviceGuiaRemision.Guardar(f);
        }

        return "redirect:/listadoGuiaRemision";

    }


    @PostMapping("/actualizarGuiaRemision")
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

        GuiaRemision f = new GuiaRemision();
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
        serviceGuiaRemision.Guardar(f);
        return "redirect:/listadoGuiaRemision";
    }

    @PostMapping("/buscarGuiaRemision")
    public String Buscar(@RequestParam("dato") String dato, Model model) {
        List<GuiaRemision> guia_remision = serviceGuiaRemision.Buscar(dato);
        model.addAttribute("GuiaRemision", guia_remision);
        return "GuiaRemision/listadoGuiaRemision";
    }

    @GetMapping("/ascendente")
    public String MostrarAscendente(Model model) {
        List<GuiaRemision> guia_remision = serviceGuiaRemision.ListarOrdenAscendente();
        model.addAttribute("GuiaRemision", guia_remision);
        return "GuiaRemision/listadoGuiaRemision";
    }

    @GetMapping("/descendente")
    public String MostrarDescendente(Model model) {
        List<GuiaRemision> guia_remision = serviceGuiaRemision.ListarOrdenDescendente();
        model.addAttribute("GuiaRemision", guia_remision);
        return "GuiaRemision/listadoGuiaRemision";
    }
}
