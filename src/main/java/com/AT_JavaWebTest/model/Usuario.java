package com.AT_JavaWebTest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class Usuario
{
    private String nome;
    private String email;
    private int idade;

    public Usuario() {}

    public Usuario(String nome, String email, int idade)
    {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }



    @Override
    public String toString()
    {
        return "Usuario{" + "nome='" + nome + '\'' + ", email='" + email + '\'' + ", idade=" + idade + '}';
    }

    public String getEmail() {
        return email;
    }

    public Usuario setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Usuario setNome(String nome) {
        this.nome = nome;
        return this;
    }
    public int getIdade() {
        return idade;
    }

    public Usuario setIdade(int idade) {
        this.idade = idade;
        return this;
    }
}
