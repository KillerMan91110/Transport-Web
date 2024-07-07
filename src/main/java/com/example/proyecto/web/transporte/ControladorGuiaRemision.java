package com.example.proyecto.web.transporte;

import com.example.proyecto.web.transporte.dto.GuiaRemisionDto;
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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("guiaRemision")
public class ControladorGuiaRemision {

    @Autowired
    private IGuiaRemisionService serviceGuiaRemision;
    @Autowired
    private IEmpleadosService empleadoService;

    @GetMapping("/list")
    public String Mostrar(Model model, @AuthenticationPrincipal CustomUserDetails userDetails) {
        if(userDetails != null) {
            String username = userDetails.getUsername();
            Empleados empleados = empleadoService.consultarUsername(username).orElse(null);
            assert empleados != null;
            boolean isAdmin = userDetails.getAuthorities().stream()
                    .anyMatch(auth -> auth.getAuthority().equals("ADMINISTRADOR"));
            if (isAdmin) {

                model.addAttribute("GuiaRemision", serviceGuiaRemision.Listar());
            } else {

                model.addAttribute("GuiaRemision", serviceGuiaRemision.ListarPorEmpleado(empleados.getId()));
            }
        }
        model.addAttribute("empleados", empleadoService.Listar());
        return "GuiaRemision/listadoGuiaRemision";
    }

    @PatchMapping("/list/estado/{id}" )
    public ResponseEntity<Void> cambiarEstado(@PathVariable("id") int id, @RequestParam String estado){
        serviceGuiaRemision.actualizarEstadoGuia(id,estado);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/guia/{id}")
    public ResponseEntity<GuiaRemisionDto> findById(@PathVariable("id") int id) {
        return ResponseEntity.ok(serviceGuiaRemision.ConsultarId(id));
    }

    @DeleteMapping ("/guia/{idGuiaRemision}")
    public ResponseEntity<Void> Eliminar(@PathVariable("idGuiaRemision") int id, Model model) {
        serviceGuiaRemision.Eliminar(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/registro")
    public String registroGuiaRemision(Model model) {
        model.addAttribute("guiaRemision", new GuiaRemisionDto());
        model.addAttribute("empleados", empleadoService.Listar());
        return "GuiaRemision/registroGuiaRemision";
    }

    @PostMapping("/registro")
    public String Registrar(@ModelAttribute GuiaRemisionDto guiaRemisionDto ){
        serviceGuiaRemision.GuardarDto(guiaRemisionDto);
        return "redirect:/guiaRemision/list";
    }

    @PutMapping("/guia/{idGuiaRemision}")
    public ResponseEntity<Void> Actualizar(@PathVariable("idGuiaRemision") int id, @ModelAttribute GuiaRemisionDto guiaRemisionDto ) {
        serviceGuiaRemision.actualizar(id,guiaRemisionDto);
        return ResponseEntity.ok().build();
    }

}