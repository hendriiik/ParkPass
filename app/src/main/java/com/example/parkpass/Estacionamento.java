package com.example.parkpass;

import java.util.Map;

public class Estacionamento {
    private int id;
    private float nota, preco;
    private String nome, cnpj, email, telefone, funcionamento;
    private ListaDeVagas listaVagas;

    public Estacionamento (int id, String nome, String cnpj, String email,
                           String telefone, ListaDeVagas listaVagas, float nota, float preco, String funcionamento) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.listaVagas = listaVagas;
        this.nota = nota;
        this.preco = preco;
        this.funcionamento = funcionamento;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ListaDeVagas buscarVagas() {
        return listaVagas;
    }

    public ListaDeVagas getListaVagas() {
        return listaVagas;
    }

    public void setListaVagas(ListaDeVagas listaVagas) {
        this.listaVagas = listaVagas;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getFuncionamento() {
        return funcionamento;
    }

    public void setFuncionamento(String funcionamento) {
        this.funcionamento = funcionamento;
    }
}
