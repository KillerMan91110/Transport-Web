package com.example.proyecto.web.transporte;

import com.example.proyecto.web.transporte.clientes.Clientes;
import com.example.proyecto.web.transporte.clientes.IClientesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControladorClientes {

    @Autowired
    private IClientesService service;

    @GetMapping("/listadoClientes")
    public String Mostrar(Model model) {
        List<Clientes> clientes = service.Listar();
        model.addAttribute("clientes", clientes);
        return "clientes/listadoClientes";
    }


    @GetMapping("/eliminarClientes")
    public String Eliminar(@RequestParam("id") int id, Model model) {

        service.Eliminar(id);
        return "redirect:/listadoClientes";
    }

    @PostMapping("/registroCliente")
    public String Registrar(@RequestParam("razonsocial") String razonSocial,
                            @RequestParam("ruc") String ruc,
                            @RequestParam("direccion") String direccion,
                            @RequestParam("telefono") String telefono,Model model) {
        Clientes cl = new Clientes();
        cl.setRazonSocial(razonSocial);
        cl.setRuc(ruc);
        cl.setDireccion(direccion);
        cl.setTelefono(telefono);
        service.Guardar(cl);
        return "redirect:/listadoClientes";
    }

    @PostMapping("/actualizarCliente")
    public String Actualizar(@RequestParam("id") int id,
                             @RequestParam("razonsocial") String razonSocial,
                             @RequestParam("ruc") String ruc,
                             @RequestParam("direccion") String direccion,
                             @RequestParam("telefono") String telefono,Model model) {
        Clientes cl = new Clientes();
        cl.setId(id);
        cl.setRazonSocial(razonSocial);
        cl.setRuc(ruc);
        cl.setDireccion(direccion);
        cl.setTelefono(telefono);
        service.Guardar(cl);

        return "redirect:/listadoClientes";
    }

    @PostMapping("/buscarClientes")
    public String Buscar(@RequestParam("dato") String dato, Model model) {
        List<Clientes> clientes = service.Listar();
        model.addAttribute("clientes", clientes);
        return "clientes/listadoClientes";
    }

    @GetMapping("/clientes/validar")
    @ResponseBody
    public boolean validarCliente(@RequestParam("razonsocial") String razonSocial, @RequestParam("ruc") String ruc) {
        List<Clientes> clientes = service.Listar();
        for (Clientes cliente : clientes) {
            if (cliente.getRazonSocial().equalsIgnoreCase(razonSocial) || cliente.getRuc().equalsIgnoreCase(ruc)) {
                return true;
            }
        }
        return false;
    }
}
