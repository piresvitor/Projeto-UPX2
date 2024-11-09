package com.projeto.UPX2.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String cep;
    private String rua;
    private String bairo;
    private String cidade;
    private String estado;
    @Column(nullable = false, unique = true)
    private String cnpj;

    @Column(nullable = false)
    private String razaoSocial;

    @Column
    private List<String> tiposMateriaisReciclados; // Por exemplo, "Vidro", "Plástico", "Papel"

    public PessoaJuridica() {}

    public PessoaJuridica(String nome, String email, String senha, Endereco endereco, String cnpj, String razaoSocial, List<String> tiposMateriaisReciclados) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.tiposMateriaisReciclados = tiposMateriaisReciclados;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cep = endereco.cep();
        this.rua = endereco.rua();
        this.bairo = endereco.bairro();
        this.cidade = endereco.cidade();
        this.estado = endereco.estado();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairo() {
        return bairo;
    }

    public void setBairo(String bairo) {
        this.bairo = bairo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public List<String> getTiposMateriaisReciclados() {
        return tiposMateriaisReciclados;
    }

    public void setTiposMateriaisReciclados(List<String> tiposMateriaisReciclados) {
        this.tiposMateriaisReciclados = tiposMateriaisReciclados;
    }
}
