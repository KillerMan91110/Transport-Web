package com.example.proyecto.web.transporte.empleados;

import com.example.proyecto.web.transporte.roles.IRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadosService implements IEmpleadosService {

    private final IEmpleados data;
    private final IRoles datarol;

    @Autowired
    public EmpleadosService(IEmpleados data, IRoles datarol) {
        this.data = data;
        this.datarol = datarol;
    }

    @Override
    public List<Empleados> Listar() {
        return data.findAllNotRole("ADMINISTRADOR");
    }

    @Override
    public Optional<Empleados> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public Optional<Empleados> buscarPorNumeroLicencia(String num_licencia) {
        return data.buscarNumLicencia(num_licencia);
    }

    @Override
    public Optional<Empleados> consultarUsername(String username) {
        return data.findByUsername(username);
    }

    @Override
    public void Guardar(Empleados a) {
        a.setPassword(PasswordEncode(a.getPassword()));
        a.setEnabled(true);
        a.addRole(datarol.findByName("CONDUCTOR"));
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

    private String PasswordEncode(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }
}
