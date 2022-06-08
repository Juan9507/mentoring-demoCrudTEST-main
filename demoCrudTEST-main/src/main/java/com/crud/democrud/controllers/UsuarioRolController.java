package com.crud.democrud.controllers;

import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.models.UsuarioRolModel;
import com.crud.democrud.services.UsuarioRolService;
import com.crud.democrud.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

public class UsuarioRolController {
    @Autowired
    UsuarioRolService usuarioRolService;

    @GetMapping()
    public ArrayList<UsuarioRolModel> obtenerUsuarios() {
        return usuarioRolService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioRolModel guardarUsuario(@RequestBody UsuarioRolModel usuarioRol) {
        return this.usuarioRolService.guardarUsuario(usuarioRol);
    }

    @PutMapping(path = "/{id}")
    public UsuarioRolModel actualizarUsuario(@RequestBody UsuarioRolModel usuarioRol, @PathVariable("id") Long id) {
        usuarioRol.setIdrol(id);
        return this.usuarioRolService.guardarUsuario(usuarioRol);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioRolModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioRolService.obtenerPorId(id);
    }

    /*@GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad) {
        return this.usuarioRolService.obtenerPorPrioridad(prioridad);
    }*/

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
