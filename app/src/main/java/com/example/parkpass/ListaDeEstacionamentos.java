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
        adicionarEstacionamento(new Estacionamento(101, "Estacionamento VIP", "123456789", "contato@estacionamentovip.com", "987654321", new ListaDeVagas(), 4.9f, 25.00f, "07:00 - 22:00"));
        adicionarEstacionamento(new Estacionamento(202, "Estacionamento Central", "987654321", "contato@estacionamentocentral.com", "123456789", new ListaDeVagas(), 4.5f, 18.50f, "09:00 - 20:00"));
        adicionarEstacionamento(new Estacionamento(303, "Estacionamento Rápido e Seguro", "234567890", "contato@estacionamentorapido.com", "987654321", new ListaDeVagas(), 4.7f, 15.75f, "08:30 - 18:30"));
        adicionarEstacionamento(new Estacionamento(404, "Estacionamento Amigo do Ambiente", "345678901", "contato@amigoambiental.com", "234567890", new ListaDeVagas(), 4.2f, 12.99f, "10:00 - 21:00"));
        adicionarEstacionamento(new Estacionamento(505, "Estacionamento Noturno", "456789012", "contato@estacionamentonoturno.com", "345678901", new ListaDeVagas(), 3.8f, 22.50f, "18:00 - 03:00"));
        adicionarEstacionamento(new Estacionamento(606, "Estacionamento Familiar", "567890123", "contato@estacionamentofamiliar.com", "456789012", new ListaDeVagas(), 4.6f, 20.00f, "09:00 - 19:00"));
        adicionarEstacionamento(new Estacionamento(707, "Estacionamento Expresso", "678901234", "contato@estacionamentoexpresso.com", "567890123", new ListaDeVagas(), 4.4f, 17.25f, "07:30 - 22:30"));
        adicionarEstacionamento(new Estacionamento(808, "Estacionamento Seguro", "789012345", "contato@estacionamentoseguro.com", "678901234", new ListaDeVagas(), 4.1f, 14.00f, "11:00 - 20:00"));
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
