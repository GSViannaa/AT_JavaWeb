package com.AT_JavaWebTest;

import com.AT_JavaWebTest.controllers.HelloController;
import com.AT_JavaWebTest.controllers.UsuarioController;
import io.javalin.Javalin;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;




public class Testes
{
    private static Javalin app;

    @BeforeAll
    public static void iniciarServidor()
    {
        app = Javalin.create().start(7070);
        new HelloController(app);
        new UsuarioController(app);

        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 7070;
    }

    @AfterAll
    public static void pararServidor() {
        app.stop();
    }

    @Test
    public void testHello() {
        when()
                .get("/hello")
                .then()
                .statusCode(200)
                .body(equalTo("Hello, Javalin!"));
    }

    @Test
    public void testCriacaoUsuario() {
        given()
                .contentType("application/json")
                .body("""
                {
                    "nome": "Gabriel",
                    "email": "gabriel@email.com",
                    "idade": 20
                }
                """)
                .when()
                .post("/usuarios")
                .then()
                .statusCode(201)
                .body("email", equalTo("gabriel@email.com"));
    }

    @Test
    public void testBuscarUsuarioPorEmail() {

        given()
                .contentType("application/json")
                .body("""
                {
                    "nome": "Gabriel",
                    "email": "gabriel@email.com",
                    "idade": 20
                }
                """)
                .when()
                .post("/usuarios");


        when()
                .get("/usuarios/gabriel@email.com")
                .then()
                .statusCode(200)
                .body("nome", equalTo("Gabriel"));
    }

    @Test
    public void testListarUsuarios() {

        given()
                .contentType("application/json")
                .body("""
                {
                    "nome": "Gabriel",
                    "email": "gabriel@email.com",
                    "idade": 20
                }
                """)
                .when()
                .post("/usuarios");


        when()
                .get("/usuarios")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }
}
