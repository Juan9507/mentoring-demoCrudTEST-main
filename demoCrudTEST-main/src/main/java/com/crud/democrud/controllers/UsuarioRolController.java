package com.crud.democrud.controllers;

import com.crud.democrud.models.UsuarioRolModel;
import com.crud.democrud.services.UsuarioRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping("/usuario/rol")
public class UsuarioRolController {

    /**
     * Inyeccion de la dependencia service UsuarioRolService
     */
    @Autowired
    UsuarioRolService usuarioRolService;

    /**
     * Obtener los roles de los usuarios
     *
     * @return - Devuelve los roles de los usuarios almacenados
     */
    @GetMapping()
    public ArrayList<UsuarioRolModel> obtenerUsuarios() {
        return usuarioRolService.obtenerUsuarios();
    }

    /**
     * Insertar un rol
     *
     * @param usuarioRol - se envia los datos del rol
     * @return - devuelve el rol
     */
    @PostMapping()
    public UsuarioRolModel guardarUsuario(@RequestBody UsuarioRolModel usuarioRol) {
        return this.usuarioRolService.guardarUsuario(usuarioRol);
    }

    /**
     * Actulizar un rol
     *
     * @param usuarioRol - se envia los datos del rol a actualizar
     * @param id         - se pasa el id del rol
     * @return - retorna el rol
     */
    @PutMapping(path = "/{id}")
    public UsuarioRolModel actualizarUsuario(@RequestBody UsuarioRolModel usuarioRol, @PathVariable("id") Long id) {
        usuarioRol.setIdrol(id);
        return this.usuarioRolService.actualizarUsuario(usuarioRol);
    }

    /**
     * Obtener un rol dependiendo el id
     *
     * @param id - se envia el id del rol
     * @return - devuelve el rol
     */
    @GetMapping(path = "/{id}")
    public Optional<UsuarioRolModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioRolService.obtenerPorId(id);
    }


    /**
     * Elminar un rol dependiendo el id
     *
     * @param id - se envia el id
     * @return - devuleve un mensaje de eliminacion
     */
    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.usuarioRolService.eliminarUsuario(id);
        if (ok) {
            return "Se eliminó el usuario con id " + id;
        } else {
            return "No pudo eliminar el usuario con id" + id;
        }
    }
}
