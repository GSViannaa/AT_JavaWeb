package com.AT_JavaWebTest.controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import java.util.Map;

public class SaudacaoController
{

    public SaudacaoController(Javalin app) {
        app.get("/saudacao/{nome}", this::saudar);
    }

    private void saudar(Context ctx) {
        String nome = ctx.pathParam("nome");
        ctx.json(Map.of("mensagem", "Olá, " + nome + "!"));
    }

}
