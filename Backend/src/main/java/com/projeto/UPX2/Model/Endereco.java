package com.projeto.UPX2.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Endereco(@JsonAlias("cep") String cep,
    @JsonAlias("logradouro") String rua,
    @JsonAlias("bairro") String bairro,
    @JsonAlias("localidade") String cidade,
    @JsonAlias("estado") String estado) {
}
