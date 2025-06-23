package com.AT_JavaWebTest.controllers;

import com.AT_JavaWebTest.model.Usuario;
import com.AT_JavaWebTest.services.UsuarioService;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.List;
import java.util.Map;

public class UsuarioController
{
    private final UsuarioService usuarioService = new UsuarioService();

    public static void configurarRotas(Javalin app)
    {

        app.post("/usuarios", ctx ->
        {
            Usuario usuario = ctx.bodyAsClass(Usuario.class);
            System.out.println("Recebido: " + usuario);
            ctx.status(201).json(usuario);
        });

        app.get("/usuarios", ctx ->
        {
            ctx.json(List.of(new Usuario("Ana", "ana@email.com", 20)));
        });

        app.get("/usuarios/{id}", ctx ->
        {
            int id = Integer.parseInt(ctx.pathParam("id"));
            ctx.json(new Usuario("Lorena " + id, "id" + id + "@email.com", 30));
        });

        app.get("/status", ctx ->
        {
            ctx.json(Map.of("status", "ok", "timestamp", System.currentTimeMillis()));
        });
    }

    public UsuarioController(Javalin app)
    {
        app.post("/usuarios", this::criarUsuario);
        app.get("/usuarios", this::listarUsuarios);
        app.get("/usuarios/{email}", this::buscarPorEmail);
    }

    private void criarUsuario(Context ctx)
    {
        Usuario novoUsuario = ctx.bodyAsClass(Usuario.class);
        usuarioService.adicionarUsuario(novoUsuario);
        ctx.status(201).json(novoUsuario);
    }

    private void listarUsuarios(Context ctx)
    {
        ctx.json(usuarioService.listarTodos());
    }

    private void buscarPorEmail(Context ctx)
    {
        String email = ctx.pathParam("email");

        usuarioService.buscarPorEmail(email).ifPresentOrElse(
                usuario -> ctx.json(usuario),
                () -> ctx.status(404).result("Usuário não encontrado, 404")
        );
    }
}
