package com.AT_JavaWebTest.controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class HelloController {

    public HelloController(Javalin app) {
        app.get("/hello", this::hello);
    }

    private void hello(Context ctx)
    {
        ctx.result("Hello, Javalin!");
    }
}
