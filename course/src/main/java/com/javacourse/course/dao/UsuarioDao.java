package com.javacourse.course.dao;

import com.javacourse.course.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuarios();

    void eliminar(Long id);

    void register(Usuario usuario);
}
