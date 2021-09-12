package br.edu.ifpb.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private Set<Contato> contatos = new HashSet<>();

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
}
