package com.example.proyecto.web.transporte;


import com.example.proyecto.web.transporte.carretas.Carretas;
import com.example.proyecto.web.transporte.carretas.ICarretasService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorCarretas {

    @Autowired
    private ICarretasService serviceCarretas;

    @GetMapping("listadoCarretas")
    public String Mostrar(Model model) {
        List<Carretas> carretas = serviceCarretas.Listar();
        model.addAttribute("carretas", carretas);
        return "camiones/listadoCarretas";
    }

    @GetMapping("/eliminarCarreta")
    public String Eliminar(@RequestParam("id") int id, Model model) {

        serviceCarretas.Eliminar(id);
        return Mostrar(model);
    }

    @PostMapping("/registroCarreta")
    public String Registrar(@RequestParam("PlacaCarreta") String PlacaCarreta,
            @RequestParam("Peso") String Peso,
            @RequestParam("Largo") String Largo,
            @RequestParam("Ancho") String Ancho,
            Model model) {
        Carretas c = new Carretas();
        c.setPlacaCarreta(PlacaCarreta);
        c.setPeso(Peso);
        c.setLargo(Largo);
        c.setAncho(Ancho);
        serviceCarretas.Guardar(c);
        return Mostrar(model);
    }
    @PostMapping("/actualizarCarreta")
    public String Actualizar(@RequestParam("id") int id,
           @RequestParam("PlacaCarreta") String PlacaCarreta,
            @RequestParam("Peso") String Peso,
            @RequestParam("Largo") String Largo,
            @RequestParam("Ancho") String Ancho,
            Model model) {
        Carretas c = new Carretas();
        c.setId(id);
        c.setPlacaCarreta(PlacaCarreta);
        c.setPeso(Peso);
        c.setLargo(Largo);
        c.setAncho(Ancho);
        return Mostrar(model);
    }

    @PostMapping("/buscarCarreta")
    public String Buscar(@RequestParam("dato") String dato, Model model) {
        List<Carretas> carretas = serviceCarretas.Listar();
        model.addAttribute("carretas", carretas);

         return "camiones/listadoCarretas";
    }

    /*@GetMapping("/ascendenteViajes")
    public String MostrarAscendente(Model model) {
        List<Viajes> viajes = serviceViaje.ListarOrdenAscendente();
        model.addAttribute("viajes", viajes);
        return "camiones/listadoCarretas";//listaantenciones.html
    }

    @GetMapping("/descendenteViajes")
    public String MostrarDescendente(Model model) {
        List<Viajes> viajes = serviceViaje.ListarOrdenDescendente();
        model.addAttribute("viajes", viajes);
        return "camiones/listadoCarretas";//listaantenciones.html
    }*/
}
