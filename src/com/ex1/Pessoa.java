package com.ex1;

public class Pessoa {
    private String nome;
    private String sobrenome;
    private int idade;
    private String username;
    private String email;

    private Pessoa(String nome, String sobrenome, int idade, String username, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.username = username;
        this.email = email;
    }

    public static class PessoaBuilder{
        private String nome;
        private String sobrenome;
        private int idade;
        private String username;
        private String email;

        public PessoaBuilder nome(String nome){
            this.nome = nome;
            return this;
        }

        public PessoaBuilder sobrenome(String sobrenome){
            this.sobrenome = sobrenome;
            return this;
        }
        public PessoaBuilder idade(int idade){
            this.idade = idade;
            return this;
        }

        public PessoaBuilder username(String username){
            this.username = username;
            return this;
        }

        public PessoaBuilder email(String email){
            this.email = email;
            return this;
        }

        public Pessoa build(){
            return new Pessoa(nome, sobrenome, idade, username, email);
        }
    }
}


