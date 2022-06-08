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
    private Long IdUsuario;
    private String Rol;

    public Long getIdrol() {
        return Idrol;
    }

    /**
     * Punto de enlace con la entidad Contacto (un contacto puede tener muchos número de teléfono)
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = UsuarioModel.class, optional = false)
    @JoinColumn(name = "user_usuario_id", nullable = false)
    @JsonManagedReference
    private UsuarioModel usuario;

    public void setIdrol(Long idrol) {
        Idrol = idrol;
    }

    public Long getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String rol) {
        Rol = rol;
    }



    public UsuarioRolModel(Long Idrol, Long IdUsuario, String rol) {
        this.Idrol = Idrol;
        this.IdUsuario = IdUsuario;
        this.Rol = Rol;
    }

    public UsuarioRolModel() {

    }
}
