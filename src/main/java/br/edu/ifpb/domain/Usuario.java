package br.edu.ifpb.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
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

    public boolean addContato(Contato contato) {
        return contatos.add(contato);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getEmail());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario other = (Usuario) obj;
        return Objects.equals(getEmail(), other.getEmail());
    }
}
