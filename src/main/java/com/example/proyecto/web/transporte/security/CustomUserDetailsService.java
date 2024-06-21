package com.example.proyecto.web.transporte.security;

import com.example.proyecto.web.transporte.empleados.Empleados;
import com.example.proyecto.web.transporte.empleados.IEmpleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private IEmpleados userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Empleados user = userRepo.findByUsername(username).orElse(null);
        if(user == null) {
            throw new UsernameNotFoundException("El usuario no se encontro");
        }
        return new CustomUserDetails(user);
    }
}
