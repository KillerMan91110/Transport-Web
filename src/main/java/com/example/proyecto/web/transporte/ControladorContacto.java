package com.example.proyecto.web.transporte;

import com.example.proyecto.web.transporte.contacto.Contacto;
import com.example.proyecto.web.transporte.contacto.ContactoService;
import com.example.proyecto.web.transporte.dto.ContactCreate;
import com.example.proyecto.web.transporte.dto.response.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("contacto")
@RequiredArgsConstructor
public class ControladorContacto {

    private final ContactoService service;

    @GetMapping
    public String registro(Model model){
        model.addAttribute("newContact", new Contacto());
        return "contactanos/registroContacto";
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE } )
    @ResponseBody
    public GenericResponse agregarContacto(@ModelAttribute ContactCreate contactCreate){
        service.save(contactCreate);
        return new GenericResponse("OK");
    }

    @GetMapping(value = "/list")
    public String lista(Model model){
        model.addAttribute("contactos", service.obtenerContactos());
        return "contactanos/listadoContactos";
    }

    @DeleteMapping(value = "/list/{id_contacto}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public GenericResponse eliminarContacto(@PathVariable("id_contacto") int id){
        service.delete(id);
        return new GenericResponse("OK");
    }

    @DeleteMapping(value = "/list/delete", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public GenericResponse eliminarTodo(){
        service.deleteAll();
        return new GenericResponse("OK");
    }

}
