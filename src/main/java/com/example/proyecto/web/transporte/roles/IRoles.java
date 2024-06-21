package com.example.proyecto.web.transporte.roles;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoles extends JpaRepository<Roles, Integer> {
    Roles findByName(String rol);
}