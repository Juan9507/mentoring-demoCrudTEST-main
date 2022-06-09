package com.crud.democrud.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
public class UsuarioModel {

    /**
     * Atributo id, clave primaria de la tabla usuario
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    /**
     * Atributo nombre
     */
    private String nombre;

    /**
     * Atributo email
     */
    private String email;

    /**
     * Atributo prioridad
     */
    private Integer prioridad;

    /**
     * Modificar la priodad
     * @param prioridad - recibe el dato para modifocar
     */
    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * mostrar la prioridad
     * @return - devuelve la prioridad
     */
    public Integer getPrioridad() {
        return prioridad;
    }

    /**
     * Mostrar el id
     * @return - devuelve el id
     */
    public Long getId() {
        return id;
    }

    /**
     * Modficar el id
     * @param id - recibe el dato para modificar
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Mostrar el nombre
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modificar el nombre
     * @param nombre - recibe el dato par modificar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Mostrar el email
     * @return - devuelve el email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Punto de enlace entre la entidad del usuario y rol
     * (un usuario puede tener muchos roles)
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<UsuarioRolModel> lines;

    /**
     * Controlador con tres parametros
     * @param nombre
     * @param email
     * @param prioridad
     */
    public UsuarioModel(String nombre, String email, Integer prioridad) {
        this.nombre = nombre;
        this.email = email;
        this.prioridad = prioridad;
    }

    /**
     * Controlador vacio
     */
    public UsuarioModel() {

    }

    /**
     * Modificar el email
     * @param email - recibe el dato para modificar el email
     */
    public void setEmail(String email) {
        this.email = email;
    }

}