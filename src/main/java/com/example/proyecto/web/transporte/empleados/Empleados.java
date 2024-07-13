package com.example.proyecto.web.transporte.empleados;

import com.example.proyecto.web.transporte.guia_remision.GuiaRemision;
import com.example.proyecto.web.transporte.roles.Roles;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="empleados")
public class Empleados {



    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Autoincremental
    @Column(name = "id")
    int id;
    String dni;
    String nombre;

    //--------
    //Parametros para usar en el login
    String username;
    String password;
    boolean enabled;

    /**
     * Crea una tabla intermedia entre Empleados y Roles
     * */
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "user_rol", joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "rol_id"))
    private Set<Roles> roles = new HashSet<>();
    //--------
    String sexo;
    String num_licencia;
    String celular;
    String correo;
    String direccion;

    @OneToMany(mappedBy = "empleados", cascade = CascadeType.ALL, orphanRemoval = false)
    private Set<GuiaRemision> guia_remision = new HashSet<>();

    /**
     * Agrega un Rol
     */
    public void addRole(Roles role) {
        this.roles.add(role);
    }

    /**
     * Verifica si el usuario tiene el Rol
     * */
    public boolean hasRole(String roleName) {
        for (Roles role : this.roles) {
            if (role.getName().equals(roleName)) {
                return true;
            }
        }
        return false;
    }
}
