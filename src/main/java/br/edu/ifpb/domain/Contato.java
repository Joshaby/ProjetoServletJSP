package br.edu.ifpb.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Contato {

    private String nome;
    private Integer rg;
    private Integer cpf;
    private Set<Endereco> enderecos = new HashSet<>();

    public Contato(String nome, Integer rg, Integer cpf, Endereco endereco) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        enderecos.add(endereco);
    }
}
