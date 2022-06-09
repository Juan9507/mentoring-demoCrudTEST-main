package com.crud.democrud.ServicesTest;

import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.repositories.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioServiceTest {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Test
    public void testGuardarUsuario() {
        UsuarioModel usuarioModel = new UsuarioModel("aquaman", "aqua@gmail.com", 99);
        UsuarioModel usuarioModelRegistrado = usuarioRepository.save(usuarioModel);
        assertNotNull(usuarioModelRegistrado);
    }

    @Test
    public void testBuscarUsuarioPorId() {
        Long idBuscado = 1L;
        Optional<UsuarioModel> usuarioModelBuscado = usuarioRepository.findById(idBuscado);
        assertThat(usuarioModelBuscado.get().getId()).isEqualTo(idBuscado);
    }

    @Test
    public void testListarUsuarios() {
        List<UsuarioModel> usuarioModelList = (List<UsuarioModel>) usuarioRepository.findAll();
        assertThat(usuarioModelList).size().isGreaterThan(0);
    }

    /**
     * Test para saber si actualiza un usuario
     * Realizado por Juan David Rivera
     */
    @Test
    public void testActualizarUsuario() {
        UsuarioModel usuarioModel = new UsuarioModel("aquaman", "aqua@gmail.com", 99);
        usuarioModel.setId(1L);
        UsuarioModel usuarioModelActualizado = usuarioRepository.save(usuarioModel);
        assertNotNull(usuarioModelActualizado);
    }

    /**
     * Test para saber si eliina un usuario
     * Realizado por Juan David Rivera
     */
    @Test
    public void testElimarUnUsuario() {
        Long idEliminar = 2L;
        Optional<UsuarioModel> eliminar = usuarioRepository.findById(idEliminar);
        assertThat(eliminar.get().getId()).isEqualTo(idEliminar);
    }
}
