package br.edu.ifpb.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
public class Contato {

    private Integer id;
    private String nome;
    private Integer rg;
    private Integer cpf;
    private Set<Endereco> enderecos = new HashSet<>();

    public Contato(Integer id, String nome, Integer rg, Integer cpf, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        enderecos.add(endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getCpf());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contato other = (Contato) obj;
        return Objects.equals(getCpf(), other.getCpf());
    }

    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", rg=" + rg +
                ", cpf=" + cpf +
                ", enderecos=" + enderecos +
                '}';
    }
}
