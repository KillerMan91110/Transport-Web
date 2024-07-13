package com.example.proyecto.web.transporte;

import com.example.proyecto.web.transporte.clientes.Clientes;
import com.example.proyecto.web.transporte.tractos.ITractosService;
import com.example.proyecto.web.transporte.tractos.Tractos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControladorTractos {

    @Autowired
    private ITractosService serviceTractos;

    @GetMapping("listadoTracto")
    public String Mostrar(Model model) {
        List<Tractos> tractos = serviceTractos.Listar();
        model.addAttribute("tractos", tractos);
        return "camiones/listadoTracto";
    }

    @GetMapping("/eliminarTracto")
    public String Eliminar(@RequestParam("id") int id, Model model) {

        serviceTractos.Eliminar(id);
        return "redirect:/listadoTracto";
    }

    @PostMapping("/registroTracto")
    public String Registrar(@RequestParam("PlacaTracto") String PlacaTracto,
                            @RequestParam("TipoTraccion") String TipoTraccion,
                            @RequestParam("Potencia") String Potencia,
                            @RequestParam("Motor") String Motor,
                            Model model) {
        Tractos t = new Tractos();
        t.setPlacaTracto(PlacaTracto);
        t.setTipoTraccion(TipoTraccion);
        t.setPotencia(Potencia);
        t.setMotor(Motor);
        serviceTractos.Guardar(t);
        return "redirect:/listadoTracto";
    }

    @PostMapping("/actualizarTracto")
    public String Actualizar(@RequestParam("id") int id,
                             @RequestParam("PlacaTracto") String PlacaTracto,
                             @RequestParam("TipoTraccion") String TipoTraccion,
                             @RequestParam("Potencia") String Potencia,
                             @RequestParam("Motor") String Motor,
                             Model model) {
        Tractos t = new Tractos();
        t.setId(id);
        t.setPlacaTracto(PlacaTracto);
        t.setTipoTraccion(TipoTraccion);
        t.setPotencia(Potencia);
        t.setMotor(Motor);
        return "redirect:/listadoTracto";
    }

    @PostMapping("/buscarTracto")
    public String Buscar(@RequestParam("dato") String dato, Model model) {
        List<Tractos> tractos = serviceTractos.Listar();
        model.addAttribute("tractos", tractos);

        return "camiones/listadoTracto";
    }

    @GetMapping("/tractos/validar")
    @ResponseBody
    public boolean validarTracto(@RequestParam("PlacaTracto") String PlacaTracto) {
        List<Tractos> tractos = serviceTractos.Listar();
        for (Tractos tracto : tractos) {
            if ( tracto.getPlacaTracto().equalsIgnoreCase(PlacaTracto)) {
                return true;
            }
        }
        return false;
    }
}
