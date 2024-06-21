package com.example.proyecto.web.transporte;


import com.example.proyecto.web.transporte.carretas.Carretas;
import com.example.proyecto.web.transporte.carretas.ICarretasService;
import com.example.proyecto.web.transporte.clientes.Clientes;
import com.example.proyecto.web.transporte.clientes.IClientesService;
import com.example.proyecto.web.transporte.empleados.Empleados;
import com.example.proyecto.web.transporte.empleados.IEmpleadosService;
import com.example.proyecto.web.transporte.tractos.ITractosService;
import com.example.proyecto.web.transporte.tractos.Tractos;
import com.example.proyecto.web.transporte.viajes.Viajes;
import com.example.proyecto.web.transporte.viajes.IViajesService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorViajes {
    @Autowired
    private IViajesService serviceViaje;

    @Autowired
    private IEmpleadosService serviceE;

    @Autowired
    private ICarretasService serviceC;

    @Autowired
    private ITractosService serviceT;

    @Autowired
    private IClientesService serviceCli;

    @GetMapping("/listadoViajes")
    public String Mostrar(Model model) {
        List<Viajes> viajes = serviceViaje.Listar();
        model.addAttribute("viajes", viajes);

        List<Empleados> empleados = serviceE.Listar();
        model.addAttribute("empleados", empleados);

        List<Tractos> tractos = serviceT.Listar();
        model.addAttribute("tractos", tractos);

        List<Carretas> carretas = serviceC.Listar();
        model.addAttribute("carretas", carretas);

        List<Clientes> clientes = serviceCli.Listar();
        model.addAttribute("clientes", clientes);


        return "viajes/listadoviajes"; //listadiCamiones.html
    }

    @GetMapping("/eliminarViaje")
    public String Eliminar(@RequestParam("id") int id, Model model) {

        serviceViaje.Eliminar(id);
        return "redirect:/listadoViajes";
    }

    @GetMapping("/registroViajes") // http://localhost/
    public String registroViajes() {
        return "viajes/registroViajes"; //new_servicio.html
    }

    @PostMapping("/registroViajes")
    public String Registrar(@RequestParam("Fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") Date Fecha,
                            @RequestParam("TipoServicio") String TipoServicio,
                            @RequestParam("nombre") Empleados nombre,
                            @RequestParam("PlacaTracto") Tractos PlacaTracto,
                            @RequestParam("PlacaCarreta") Carretas PlacaCarreta,
                            @RequestParam("nombre") Clientes Nombre,
                            @RequestParam("Destino") String Destino,
                            @RequestParam("AlmacenRetiroContenedor") String AlmacenRetiroContenedor,
                            @RequestParam("AlmacenDevolucionContenedor") String AlmacenDevolucionContenedor,
                            @RequestParam("MontoViaje") Float MontoViaje,
                            Model model) {
        Viajes v = new Viajes();
        v.setFecha(Fecha);
        v.setTipoServicio(TipoServicio);
        v.setEmpleados(nombre);
        v.setTractos(PlacaTracto);
        v.setCarretas(PlacaCarreta);
        v.setClientes(Nombre);
        v.setDestino(Destino);
        v.setAlmacenRetiroContenedor(AlmacenRetiroContenedor);
        v.setAlmacenDevolucionContenedor(AlmacenDevolucionContenedor);
        v.setMontoViaje(MontoViaje);
        serviceViaje.Guardar(v);
        return "redirect:/listadoViajes";
    }

    /*@GetMapping("/editarViaje")
    public String Editar(@RequestParam("id") int id, Model model) {
        Optional<Viajes> viajes = service.ConsultarId(id);
        model.addAttribute("Viajes", viajes);
        return "viajes/editarViaje"; //editarEmpleado.html
    }*/

    @PostMapping("/actualizarViajes")
    public String Actualizar(@RequestParam("id") int id,
                             @RequestParam("Fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") Date Fecha,
                             @RequestParam("TipoServicio") String TipoServicio,
                             @RequestParam("nombre") Empleados nombre,
                             @RequestParam("PlacaTracto") Tractos PlacaTracto,
                             @RequestParam("PlacaCarreta") Carretas PlacaCarreta,
                             @RequestParam("nombre") Clientes Nombre,
                             @RequestParam("Destino") String Destino,
                             @RequestParam("AlmacenRetiroContenedor") String AlmacenRetiroContenedor,
                             @RequestParam("AlmacenDevolucionContenedor") String AlmacenDevolucionContenedor,
                             @RequestParam("MontoViaje") Float MontoViaje,
                             Model model) {
        Viajes v = new Viajes();
        v.setId(id);
        v.setFecha(Fecha);
        v.setTipoServicio(TipoServicio);
        v.setEmpleados(nombre);
        v.setTractos(PlacaTracto);
        v.setCarretas(PlacaCarreta);
        v.setClientes(Nombre);
        v.setDestino(Destino);
        v.setAlmacenRetiroContenedor(AlmacenRetiroContenedor);
        v.setAlmacenDevolucionContenedor(AlmacenDevolucionContenedor);
        v.setMontoViaje(MontoViaje);
        serviceViaje.Guardar(v);
        return "redirect:/listadoViajes";
    }

    @PostMapping("/buscarViaje")
    public String Buscar(@RequestParam("dato") String dato, Model model) {
        List<Viajes> viajes = serviceViaje.Buscar(dato);
        model.addAttribute("viajes", viajes);

        List<Empleados> empleados = serviceE.Listar();
        model.addAttribute("empleados", empleados);

        List<Tractos> tractos = serviceT.Listar();
        model.addAttribute("tractos", tractos);

        List<Carretas> carretas = serviceC.Listar();
        model.addAttribute("carretas", carretas);

        List<Clientes> clientes = serviceCli.Listar();
        model.addAttribute("clientes", clientes);

        return "viajes/listadoViajes";
    }
    @GetMapping("/ascendenteViajes")
    public String MostrarAscendente(Model model) {
        List<Viajes> viajes = serviceViaje.ListarOrdenAscendente();
        model.addAttribute("viajes", viajes);
        return "viajes/listadoviajes";//listaantenciones.html
    }

    @GetMapping("/descendenteViajes")
    public String MostrarDescendente(Model model) {
        List<Viajes> viajes = serviceViaje.ListarOrdenDescendente();
        model.addAttribute("viajes", viajes);
        return "viajes/listadoviajes";//listaantenciones.html
    }
    @GetMapping("/reporte")
    public String ReporteGrafico(Model model)
    {
        int cantexpo = 0;
        int cantimpo = 0;

        Map<String, Integer> graphData = new TreeMap<>();
        List<Viajes> viajes = serviceViaje.Listar();
        for (int i = 0; i < viajes.size(); i++)
        {

            String nom = viajes.get(i).getTipoServicio();
            if(nom.equals("EXPORTACION")){
                cantexpo++;
            }else{
                cantimpo++;
            }
        }
        graphData.put("EXPORTACION",cantexpo);
        graphData.put("IMPORTACION",cantimpo);

        model.addAttribute("graphData", graphData);
        return "viajes/reporteviajes"; //grafico.html
    }
}
