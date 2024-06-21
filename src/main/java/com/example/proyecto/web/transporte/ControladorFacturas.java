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
        return "facturas/listadoFacturas"; //listadiCamiones.html
    }

    @GetMapping("/eliminarFactura")
    public String Eliminar(@RequestParam("id") int id, Model model) {

        serviceFacturas.Eliminar(id);
        return "redirect:/listadoFacturas";
    }

    @GetMapping("/registroFacturas") // http://localhost/
    public String registroCamiones() {
        return "facturas/registroFacturas"; //new_servicio.html
    }

    @PostMapping("/registroFacturas")
    public String Registrar(//@RequestParam("NumOrden") int NumOrden,
                            @RequestParam("NumFactura") String NumFactura,
                            @RequestParam("NomProveedor") String NomProveedor,
                            @RequestParam("FechaEmision") @DateTimeFormat(pattern = "yyyy-MM-dd") Date FechaEmision ,
                            @RequestParam("FechaRecepcion") @DateTimeFormat(pattern = "yyyy-MM-dd") Date FechaRecepcion ,
                            //@RequestParam("MontoSoles") float MontoSoles,
                            //@RequestParam("MontoDolares") float MontoDolares,
                            @RequestParam("TipoMoneda") String TipoMoneda,
                            @RequestParam("Monto") float Monto,
                            @RequestParam("FechaPagoDetraccion") @DateTimeFormat(pattern = "yyyy-MM-dd") Date FechaPagoDetraccion ,
                            @RequestParam("DepositoDetraccion") float DepositoDetraccion,
                            @RequestParam("FechaPago") @DateTimeFormat(pattern = "yyyy-MM-dd") Date FechaPago ,
                            @RequestParam("Observacion") String Observacion,
                            Model model) throws ParseException {



        Facturas f = new Facturas();
        //f.setNumOrden(NumOrden);
        f.setNumFactura(NumFactura);
        f.setNomProveedor(NomProveedor);
        f.setFechaEmision(FechaEmision);
        f.setFechaRecepcion(FechaRecepcion);
        f.setMonto(Monto);
        f.setTipoMoneda(TipoMoneda);
        f.setFechaPagoDetraccion(FechaPagoDetraccion);
        f.setDepositoDetraccion(DepositoDetraccion);
        f.setFechaPago(FechaPago);
        f.setObservacion(Observacion);

        serviceFacturas.Guardar(f);
        return "redirect:/listadoFacturas";

    }

    /*@GetMapping("/editarViaje")
    public String Editar(@RequestParam("id") int id, Model model) {
        Optional<Viajes> viajes = service.ConsultarId(id);
        model.addAttribute("Viajes", viajes);
        return "viajes/editarViaje"; //editarEmpleado.html
    }*/
    @PostMapping("/actualizarFacturas")
    public String Actualizar(@RequestParam("id") int id,
                             //@RequestParam("NumOrden") int NumOrden,
                             @RequestParam("NumFactura") String NumFactura,
                             @RequestParam("NomProveedor") String NomProveedor,
                             @RequestParam("FechaEmision") @DateTimeFormat(pattern = "yyyy-MM-dd") Date FechaEmision ,
                             @RequestParam("FechaRecepcion") @DateTimeFormat(pattern = "yyyy-MM-dd") Date FechaRecepcion ,
                             //@RequestParam("MontoSoles") float MontoSoles,
                             //@RequestParam("MontoDolares") float MontoDolares,
                             @RequestParam("TipoMoneda") String TipoMoneda,
                             @RequestParam("Monto") float Monto,
                             @RequestParam("FechaPagoDetraccion") @DateTimeFormat(pattern = "yyyy-MM-dd") Date FechaPagoDetraccion ,
                             @RequestParam("DepositoDetraccion") float DepositoDetraccion,
                             @RequestParam("FechaPago") @DateTimeFormat(pattern = "yyyy-MM-dd") Date FechaPago ,
                             @RequestParam("Observacion") String Observacion,
                             Model model) {
        Facturas f = new Facturas();
        f.setId(id);
        //f.setNumOrden(NumOrden);
        f.setNumFactura(NumFactura);
        f.setNomProveedor(NomProveedor);
        f.setFechaEmision(FechaEmision);
        f.setFechaRecepcion(FechaRecepcion);
        //f.setMontoSoles(MontoSoles);
        //f.setMontoDolares(MontoDolares);
        f.setMonto(Monto);
        f.setTipoMoneda(TipoMoneda);
        f.setFechaPagoDetraccion(FechaPagoDetraccion);
        f.setDepositoDetraccion(DepositoDetraccion);
        f.setFechaPago(FechaPago);
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
        return "facturas/listadoFacturas";//listaantenciones.html
    }

    @GetMapping("/descendente")
    public String MostrarDescendente(Model model) {
        List<Facturas> facturas = serviceFacturas.ListarOrdenDescendente();
        model.addAttribute("facturas", facturas);
        return "facturas/listadoFacturas";//listaantenciones.html
    }
}
