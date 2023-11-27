package com.example.parkpass;

public class Responsavel {
    private String nome, email, cpf;

    public Responsavel(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public static Responsavel carregarDadosLogin() {
        //dados exemplo, supondo que foram obtidos os dados vindos do login
        return new Responsavel("João da Silva", "contato@estacionamentovip.com", "695.283.684-12");
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Estacionamento getEstacionamento() {
        ListaDeEstacionamentos listaDeEstacionamentos = new ListaDeEstacionamentos();
        listaDeEstacionamentos.carregarEstacionamentos();
        return listaDeEstacionamentos.selecionaEstacionamentoPorEmail(this.email);
    }
}
