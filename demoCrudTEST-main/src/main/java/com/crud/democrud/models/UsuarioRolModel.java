package com.crud.democrud.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "rol")
public class UsuarioRolModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Idrol;

    private String Rol;

    public Long getIdrol() {
        return Idrol;
    }

    public void setIdrol(Long idrol) {
        Idrol = idrol;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String rol) {
        Rol = rol;
    }

    /**
     * Punto de enlace con la entidad Contacto (un contacto puede tener muchos número de teléfono)
     */
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false, updatable = false)
    private UsuarioModel usuario;

    public UsuarioRolModel(Long Idrol, String rol) {
        this.Idrol = Idrol;
        this.Rol = rol;
    }

    public UsuarioRolModel() {

    }
}
