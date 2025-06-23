package com.AT_JavaWebTest.cliente;

import com.AT_JavaWebTest.model.Usuario;
import com.google.gson.Gson;

public class UsuarioCliente
{
    private static final String BASE_URL = "http://localhost:7000/usuarios";
    private static final Gson gson = new Gson();

    public static void criarUsuario(Usuario usuario)
    {
        try
        {
            String json = gson.toJson(usuario);
            String response = ApiCliente.sendPost(BASE_URL, json);
            System.out.println("Resposta do POST: " + response);
        }
        catch (Exception e)
        {
            System.err.println("Erro ao criar usuário: " + e.getMessage());
        }
    }

    public static void listarUsuarios()
    {
        try
        {
            String response = ApiCliente.sendGet(BASE_URL);
            System.out.println("Lista de usuários: " + response);
        }
        catch (Exception e)
        {
            System.err.println("Erro ao listar usuários: " + e.getMessage());
        }
    }

    public static void buscarPorId(int id)
    {
        try
        {
            String response = ApiCliente.sendGet(BASE_URL + "/" + id);
            System.out.println("Usuário encontrado: " + response);
        }
        catch (Exception e)
        {
            System.err.println("Erro ao buscar usuário: " + e.getMessage());
        }
    }

    public static void verificarStatus()
    {
        try
        {
            String response = ApiCliente.sendGet("http://localhost:7000/status");
            System.out.println("Status da API: " + response);
        }
        catch (Exception e)
        {
            System.err.println("Erro ao verificar status: " + e.getMessage());
        }
    }
}
