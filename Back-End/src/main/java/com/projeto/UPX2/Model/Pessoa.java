package com.projeto.UPX2.Model;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pessoa")
public class Pessoa {

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

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Lembrete> lembretes = new ArrayList<>();

    public Pessoa(){}

    public Pessoa(String nome, String email, String senha, Endereco endereco) {
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairo() {
        return bairo;
    }

    public void setBairo(String bairo) {
        this.bairo = bairo;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
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

    public List<Lembrete> getLembretes() {
        return lembretes;
    }

    public void setLembretes(List<Lembrete> lembretes) {
        lembretes.forEach(l -> l.setPessoa(this));
        this.lembretes = lembretes;
    }
}
