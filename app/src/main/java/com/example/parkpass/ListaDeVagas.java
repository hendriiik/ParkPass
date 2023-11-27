package com.example.parkpass;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ListaDeVagas {
    private Map<Integer, Vaga> listaVagas;

    public ListaDeVagas() {
        listaVagas = new LinkedHashMap<>();
        popularListaVagas();
    }

    public Map<Integer, Vaga> getListaVagas() {
        return listaVagas;
    }

    public void setListaVagas(Map<Integer, Vaga> listaVagas) {
        this.listaVagas = listaVagas;
    }

    private void popularListaVagas() {
        adicionarVaga(new Vaga(1, Vaga.CARRO, "XYZ-1234", true));
        adicionarVaga(new Vaga(2, Vaga.CARRO, "ABC-5678", true));
        adicionarVaga(new Vaga(3, Vaga.CARRO, "JKL-7890", true));
        adicionarVaga(new Vaga(4, Vaga.MOTO, null, false));
        adicionarVaga(new Vaga(5, Vaga.MOTO, "PQR-6789", true));
        adicionarVaga(new Vaga(6, Vaga.MOTO, null, false));
        adicionarVaga(new Vaga(7, Vaga.CARRO, "DEF-9012", true));
        adicionarVaga(new Vaga(8, Vaga.CARRO, null, false));
        adicionarVaga(new Vaga(9, Vaga.MOTO, "GHI-3456", true));
        adicionarVaga(new Vaga(10, Vaga.MOTO, null, false));
        adicionarVaga(new Vaga(11, Vaga.CARRO, null, false));
        adicionarVaga(new Vaga(12, Vaga.CARRO, null, false));
        adicionarVaga(new Vaga(13, Vaga.MOTO, "VWX-8901", true));
        adicionarVaga(new Vaga(14, Vaga.MOTO, null, false));
    }

    public void popularHistoricoVagas() {
        adicionarVaga(new Vaga(7, Vaga.CARRO, "GGG-7777", false));
        adicionarVaga(new Vaga(12, Vaga.MOTO, "LLL-2222", false));
        adicionarVaga(new Vaga(6, Vaga.MOTO, "FFF-6666", false));
        adicionarVaga(new Vaga(3, Vaga.CARRO, "CCC-3333", false));
        adicionarVaga(new Vaga(9, Vaga.CARRO, "III-9999", false));
        adicionarVaga(new Vaga(10, Vaga.MOTO, "JJJ-0000", false));
        adicionarVaga(new Vaga(4, Vaga.MOTO, "DDD-4444", false));
        adicionarVaga(new Vaga(1, Vaga.CARRO, "AAA-1111", false));
        adicionarVaga(new Vaga(13, Vaga.CARRO, "MMM-3333", false));
        adicionarVaga(new Vaga(11, Vaga.CARRO, "KKK-1111", false));
        adicionarVaga(new Vaga(2, Vaga.MOTO, "BBB-2222", false));
        adicionarVaga(new Vaga(8, Vaga.MOTO, "HHH-8888", false));
        adicionarVaga(new Vaga(5, Vaga.CARRO, "EEE-5555", false));
        adicionarVaga(new Vaga(14, Vaga.MOTO, "NNN-4444", false));
        adicionarVaga(new Vaga(2, Vaga.MOTO, "PPP-6666", false));
        adicionarVaga(new Vaga(6, Vaga.CARRO, "XYZ-1234", false));
        adicionarVaga(new Vaga(13, Vaga.CARRO, "STU-4567", false));
        adicionarVaga(new Vaga(8, Vaga.MOTO, "RRR-8888", false));
        adicionarVaga(new Vaga(1, Vaga.CARRO, "OOO-5555", false));
        adicionarVaga(new Vaga(5, Vaga.CARRO, "SSS-9999", false));
    }


    public void adicionarVaga(Vaga vaga) {
        listaVagas.put(vaga.getId(), vaga);
    }

    public void carregarVagas() {
        popularListaVagas();
    }

}
