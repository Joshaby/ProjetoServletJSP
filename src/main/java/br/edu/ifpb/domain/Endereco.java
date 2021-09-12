package br.edu.ifpb.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Endereco {

    private String rua;
    private Integer numero;
    private String complemento;
    private String bairro;
    private Integer cep;
    private String cidade;
    private String unidadeFederariva;

    @Override
    public int hashCode() {
        return Objects.hash(numero, cep);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return numero.equals(endereco.numero) && cep.equals(endereco.cep);
    }
}
