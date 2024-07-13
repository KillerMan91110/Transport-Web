package com.example.proyecto.web.transporte;

import com.example.proyecto.web.transporte.empleados.Empleados;
import com.example.proyecto.web.transporte.empleados.IEmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class Controlador {

    private final IEmpleadosService service;

    @Autowired
    public Controlador(IEmpleadosService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/nosotros")
    public String nosotros() {
        return "nosotros";
    }

    @GetMapping("/listadoEmpleados")
    public String Mostrar(Model model) {
        List<Empleados> empleados = service.Listar();
        model.addAttribute("empleados", empleados);
        return "empleados/listadoEmpleados";
    }

    @GetMapping("/eliminarEmpleado")
    public String Eliminar(@RequestParam("id") int id) {
        service.Eliminar(id);
        return "redirect:/listadoEmpleados";
    }

    @GetMapping("/registroEmpleados")
    public String registroEmpleados() {
        return "empleados/registroEmpleados";
    }

    @PostMapping("/registroEmpleados")
    public String Registrar(@RequestParam("dni") String dni,
                            @RequestParam("nombre") String nom,
                            @RequestParam("sexo") String sexo,
                            @RequestParam("num_licencia") String numLic,
                            @RequestParam("celular") String celular,
                            @RequestParam("correo") String correo,
                            @RequestParam("direccion") String direc,
                            @RequestParam("username") String user,
                            @RequestParam("password") String pass) {
        Empleados e = new Empleados();
        e.setDni(dni);
        e.setNombre(nom);
        e.setSexo(sexo);
        e.setNum_licencia(numLic);
        e.setCelular(celular);
        e.setCorreo(correo);
        e.setDireccion(direc);
        e.setUsername(user);
        e.setPassword(pass);
        service.Guardar(e);
        return "redirect:/listadoEmpleados";
    }

    @GetMapping("/editarEmpleado")
    public String Editar(@RequestParam("id") int id, Model model) {
        Optional<Empleados> empleados = service.ConsultarId(id);
        model.addAttribute("empleados", empleados);
        return "empleados/editarEmpleado";
    }

    @PostMapping("/actualizar")
    public String Actualizar(@RequestParam("id") int id,
                             @RequestParam("dni") String dni,
                             @RequestParam("nombre") String nom,
                             @RequestParam("sexo") String sexo,
                             @RequestParam("num_licencia") String numLic,
                             @RequestParam("celular") String celular,
                             @RequestParam("correo") String correo,
                             @RequestParam("direccion") String direc,
                             @RequestParam("username") String user,
                             @RequestParam("password") String pass) {
        Empleados e = new Empleados();
        e.setId(id);
        e.setDni(dni);
        e.setNombre(nom);
        e.setSexo(sexo);
        e.setNum_licencia(numLic);
        e.setCelular(celular);
        e.setCorreo(correo);
        e.setDireccion(direc);
        e.setUsername(user);
        e.setPassword(pass);
        service.Guardar(e);
        return "redirect:/listadoEmpleados";
    }

    @PostMapping("/buscar")
    public String Buscar(@RequestParam("dato") String dato, Model model) {
        List<Empleados> empleados = service.Buscar(dato);
        model.addAttribute("empleados", empleados);
        return "empleados/listadoEmpleados";
    }

    @GetMapping("/conductores/validarDNI")
    @ResponseBody
    public boolean validarDNI(@RequestParam("dni") String dni) {
        List<Empleados> empleados = service.Listar();
        for (Empleados empleado : empleados) {
            if (empleado.getDni().equalsIgnoreCase(dni)) {
                return true;
            }
        }
        return false;
    }

    @GetMapping("/conductores/validarUsername")
    @ResponseBody
    public boolean validarUsername(@RequestParam("username") String username) {
        List<Empleados> empleados = service.Listar();
        for (Empleados empleado : empleados) {
            if (empleado.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    @GetMapping("/validarLicencia")
    @ResponseBody
    public boolean validarLicencia(@RequestParam("num_licencia") String num_licencia) {
        try {
            Optional<Empleados> conductorOptional = service.buscarPorNumeroLicencia(num_licencia);
            return conductorOptional.isPresent();
        } catch (Exception e) {
            // Manejo de excepciones aquí, por ejemplo, loguear el error
            e.printStackTrace();
            return false; // o manejar el error de otra manera adecuada para tu aplicación
        }
    }
}
