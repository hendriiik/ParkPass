package com.example.parkpass;

import android.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListaDeEstacionamentos {

    private Map<Integer, Estacionamento> listaEstacionamento;

    public ListaDeEstacionamentos() {
        listaEstacionamento = new HashMap<>();
        popularListaEstacionamento();
    }

    public Map<Integer, Estacionamento> getListaEstacionamento() {
        return listaEstacionamento;
    }

    public void setListaEstacionamento(Map<Integer, Estacionamento> listaEstacionamento) {
        this.listaEstacionamento = listaEstacionamento;
    }

    private void popularListaEstacionamento() {
        // Exemplo de adição de estacionamentos fictícios
        adicionarEstacionamento(new Estacionamento(102, "Estacionamento 1", "123456789", "email1@example.com", "123456789", new ListaDeVagas(), 4.9f, 15.50f, "08:00 - 18:00"));
        adicionarEstacionamento(new Estacionamento(208, "Estacionamento 2", "987654321", "email2@example.com", "987654321", new ListaDeVagas(), 4.2f, 9.9f, "10:00 - 22:30"));
    }

    public Estacionamento selecionaEstacionamento(int idEstacionamento) {
        return listaEstacionamento.get(idEstacionamento);
    }

    public void adicionarEstacionamento(Estacionamento estacionamento) {
        listaEstacionamento.put(estacionamento.getId(), estacionamento);
    }

    public void carregarEstacionamentos() {
        popularListaEstacionamento();
    }

    public List<String> getNomesEstacionamentos() {
        List<String> nomes = new ArrayList<>();
        for (Estacionamento estacionamento : listaEstacionamento.values()) {
            nomes.add(estacionamento.getNome());
        }
        return nomes;
    }

    public Estacionamento selecionaEstacionamentoPorNome(String nome) {
        for (Estacionamento estacionamento : listaEstacionamento.values()) {
            if (estacionamento.getNome().equals(nome)) {
                return estacionamento;
            }
        }
        return null;
    }
}
