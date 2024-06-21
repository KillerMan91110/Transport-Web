package com.example.proyecto.web.transporte.empleados;

import com.example.proyecto.web.transporte.roles.IRoles;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpleadosService implements IEmpleadosService{
    private final IEmpleados data;
    private final IRoles datarol;
    
    @Override
    public List<Empleados> Listar() {
        return data.findAllNotRole("ADMINISTRADOR");
    }

    @Override
    public Optional<Empleados> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(Empleados a) {
        a.setPassword(PasswordEncode(a.getPassword()));
        a.setEnabled(true);//Habilita el usuario
        a.addRole(datarol.findByName("CONDUCTOR"));//Asigna el rol Conductor
        data.save(a);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Empleados> Buscar(String dato) {
        return data.buscarPorTodo(dato);
    }

    /**
     * Encriptar cadena para password
     * */
    private String PasswordEncode(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }
}
