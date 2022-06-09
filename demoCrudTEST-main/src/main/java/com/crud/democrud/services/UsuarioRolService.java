package com.crud.democrud.services;

import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.models.UsuarioRolModel;
import com.crud.democrud.repositories.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class UsuarioRolService {
    @Autowired
    UsuarioRolRepository usuarioRolRepository;

    public ArrayList<UsuarioRolModel> obtenerUsuarios(){
        return (ArrayList<UsuarioRolModel>) usuarioRolRepository.findAll();
    }

    public UsuarioRolModel guardarUsuario(UsuarioRolModel usuario){
        return usuarioRolRepository.save(usuario);
    }

    public UsuarioRolModel actualizarUsuario(UsuarioRolModel usuario) { return usuarioRolRepository.save(usuario);}

    public Optional<UsuarioRolModel> obtenerPorId(Long id){
        return usuarioRolRepository.findById(id);
    }


    /*public ArrayList<UsuarioRolModel>  obtenerPorPrioridad(Integer prioridad) {
        return usuarioRolRepository.findByPrioridad(prioridad);
    }*/

    public boolean eliminarUsuario(Long id) {
        try{
            usuarioRolRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
