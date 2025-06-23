package com.AT_JavaWebTest.controllers;

import com.AT_JavaWebTest.model.Mensagem;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class EchoController
{
    public EchoController(Javalin app) {
        app.post("/echo", this::echo);
    }

    private void echo(Context ctx) {
        Mensagem entrada = ctx.bodyAsClass(Mensagem.class);
        ctx.json(entrada);
    }
}
