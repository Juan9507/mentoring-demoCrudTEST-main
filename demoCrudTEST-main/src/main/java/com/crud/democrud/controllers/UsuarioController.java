package com.crud.democrud.controllers;

import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Controlador usuario
 *
 * @author Juan David Rivera <juandavidnaranjo75@gmail.com>
 * @version 1.0.0 2022-06-08
 * @since 1.0.0
 */
@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    /**
     * Inyeccion de la dependencia service UsuarioService
     */
    @Autowired
    UsuarioService usuarioService;

    /**
     * Obtener los usuarios
     *
     * @return - Devuelve los usuarios almacenados
     */
    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    /**
     * Insertar un usuario
     *
     * @param usuario - se envia los datos del usuario
     * @return - devuelve el usuario
     */
    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
        return this.usuarioService.guardarUsuario(usuario);
    }

    /**
     * Actulizar un usuario
     *
     * @param usuario - se envia los datos del usuario
     * @param id      - se pasa el id del usuario
     * @return - retorna el usuario
     */
    @PostMapping(path = "/{id}")
    public UsuarioModel actualizarUsuario(@RequestBody UsuarioModel usuario, @PathVariable("id") Long id) {
        usuario.setId(id);
        return this.usuarioService.actualizarUsuario(usuario);
    }

    /**
     * Obtener un usuario dependiendo el id
     *
     * @param id - se envia el id del usuario
     * @return - devuelve el usuario
     */
    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioService.obtenerPorId(id);
    }

    /**
     * Obtener usuario por prioridad
     *
     * @param prioridad - Se envia el numero de la prioridad
     * @return - retorna el usuario
     */
    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad) {
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    /**
     * Elminar un usuario dependiendo el id
     *
     * @param id - se envia el id
     * @return - devuleve un mensaje
     */
    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok) {
            return "Se eliminó el usuario con id " + id;
        } else {
            return "No pudo eliminar el usuario con id" + id;
        }
    }

}