package com.AT_JavaWebTest;
import com.AT_JavaWebTest.cliente.ApiCliente;
import com.AT_JavaWebTest.cliente.UsuarioCliente;
import com.AT_JavaWebTest.controllers.*;
import com.AT_JavaWebTest.model.Usuario;
import com.google.gson.Gson;
import io.javalin.Javalin;


public class App
{
    public static void main(String[] args)
    {
        Javalin app = Javalin.create().start(7000);

        app.before(ctx -> ctx.contentType("application/json"));
        app.get("/", ctx -> ctx.result(" Javalin está rodando"));

        new HelloController(app);
       // new StatusController(app);
        new EchoController(app);
        new SaudacaoController(app);
       // new UsuarioController(app);

        UsuarioController.configurarRotas(app);

        Usuario gabriel = new Usuario("Gabriel", "gabriel@email.com", 20);
        Usuario julia = new Usuario("Julia", "Julia@email.com", 20);
        Usuario ana  = new Usuario("ana", "ana@email.com", 20);
        Usuario ze  = new Usuario("ze", "ze@email.com", 20);

        UsuarioCliente.criarUsuario(gabriel);
        UsuarioCliente.criarUsuario(julia);
        UsuarioCliente.criarUsuario(ana);
        UsuarioCliente.criarUsuario(ze);

        UsuarioCliente.listarUsuarios();
        UsuarioCliente.buscarPorId(1);
        UsuarioCliente.verificarStatus();


    }
}