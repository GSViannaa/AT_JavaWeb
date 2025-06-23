package com.AT_JavaWebTest.controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;

import java.time.ZonedDateTime;
import java.util.Map;

public class StatusController
{
    public StatusController(Javalin app)
    {
        app.get("/status", this::getStatus);
    }

    private void getStatus(Context ctx)
    {
        String timestamp = ZonedDateTime.now().toString();
        ctx.json(Map.of("status", "ok", "timestamp", timestamp));
    }
}
