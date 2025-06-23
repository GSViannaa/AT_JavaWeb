package com.AT_JavaWebTest.services;

import com.AT_JavaWebTest.model.Usuario;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UsuarioService
{
    private final Map<String, Usuario> usuarios = new HashMap<>();

    public void adicionarUsuario(Usuario usuario)
    {
        usuarios.put(usuario.getEmail(), usuario);
    }

    public Collection<Usuario> listarTodos()
    {
        return usuarios.values();
    }

    public Optional<Usuario> buscarPorEmail(String email)
    {
        return Optional.ofNullable(usuarios.get(email));
    }
}
