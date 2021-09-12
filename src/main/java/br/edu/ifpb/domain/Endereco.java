package br.edu.ifpb.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
}
