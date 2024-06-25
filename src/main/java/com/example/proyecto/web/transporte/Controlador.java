
package com.example.proyecto.web.transporte;

import com.example.proyecto.web.transporte.empleados.Empleados;
import com.example.proyecto.web.transporte.empleados.IEmpleadosService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlador {

    @Autowired
    private IEmpleadosService service;
    @GetMapping("/")
    public String index() {
        return "index"; //index.html
    }
    @GetMapping("/nosotros")
    public String nosotros() {
        return "nosotros"; //index.html
    }
    @GetMapping("/listadoEmpleados")
    public String Mostrar(Model model) {
        List<Empleados> empleados = service.Listar();
        model.addAttribute("empleados", empleados); //
        return "empleados/listadoEmpleados"; //listadoEmpleados.html
    }
    @GetMapping("/eliminarEmpleado")
    public String Eliminar(@RequestParam("id") int id, Model model) {

        service.Eliminar(id);
        return "redirect:/listadoEmpleados";
    }
    @GetMapping("/registroEmpleados") // http://localhost/
    public String registroEmpleados(){
        return "empleados/registroEmpleados"; //new_servicio.html
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
                            @RequestParam("password") String pass,
                            Model model) {
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
        return "empleados/editarEmpleado"; //editarEmpleado.html
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
                             @RequestParam("password") String pass,
                             Model model) {
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

}
