package com.example.parkpass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VagasEstacionamentoActivity extends AppCompatActivity {

    private TextView txtTitulo;
    private ImageButton btnCliente;
    private Button btnHistorico, btnVagasVazias, btnVagasOcupadas;
    private ListView listVagas;
    private Responsavel responsavel;
    private Estacionamento estacionamento;
    private ListaDeVagas listaDeVagas;
    private ListaDeVagas historicoVagas;
    private List<String> dadosVagas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vagas_estacionamento);

        txtTitulo = findViewById(R.id.txtTitulo);
        btnCliente= findViewById(R.id.btnCliente);
        btnHistorico = findViewById(R.id.btnHistorico);
        btnVagasVazias = findViewById(R.id.btnVagasVazias);
        btnVagasOcupadas = findViewById(R.id.btnVagasOcupadas);
        listVagas = findViewById(R.id.listVagas);

        dadosVagas = new ArrayList<>();



        btnCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VagasEstacionamentoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnHistorico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtTitulo.getText().equals("Ocupação das vagas")) {
                    txtTitulo.setText("Histórico Vagas (Última 1 hora)");
                    btnHistorico.setText("Ocupação das vagas");
                    btnVagasOcupadas.setVisibility(View.GONE);
                    btnVagasVazias.setVisibility(View.GONE);
                    carregarHistoricoVagas();
                } else {
                    txtTitulo.setText("Ocupação das vagas");
                    btnHistorico.setText("Histórico Vagas");
                    btnVagasOcupadas.setVisibility(View.VISIBLE);
                    btnVagasVazias.setVisibility(View.VISIBLE);
                    carregarVagas();
                }
            }
        });

        btnVagasVazias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregarVagasVazias();
            }
        });

        btnVagasOcupadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregarVagasOcupadas();
            }
        });

        responsavel = Responsavel.carregarDadosLogin();
        estacionamento = responsavel.getEstacionamento();
        if (estacionamento != null) {
            listaDeVagas = estacionamento.getListaVagas();
            carregarVagas();

            historicoVagas = new ListaDeVagas();
            historicoVagas.popularHistoricoVagas();

        }
    }

    private void carregarVagas() {
        if (listaDeVagas == null) return;

        for (Map.Entry<Integer, Vaga> entry : listaDeVagas.getListaVagas().entrySet()) {
            Vaga vaga = entry.getValue();
            dadosVagas.add(String.format("%02d (%s) - %s", vaga.getId(), vaga.getTipo(), vaga.isOcupada() ? "ocupada por "+vaga.getPlaca() : "vazia"));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dadosVagas);
        listVagas.setAdapter(adapter);
    }

    private void carregarHistoricoVagas() {
        List<String> dadosHistoricoVagas = new ArrayList<>();
        for (Map.Entry<Integer, Vaga> entry : historicoVagas.getListaVagas().entrySet()) {
            Vaga vaga = entry.getValue();
            dadosHistoricoVagas.add(String.format("%02d (%s) - ocupada por %s", vaga.getId(), vaga.getTipo(), vaga.getPlaca()));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dadosHistoricoVagas);
        listVagas.setAdapter(adapter);
    }

    private void carregarVagasVazias() {
        dadosVagas.clear();
        for (Map.Entry<Integer, Vaga> entry : listaDeVagas.getListaVagas().entrySet()) {
            Vaga vaga = entry.getValue();
            if (!vaga.isOcupada()) {
                dadosVagas.add(String.format("%02d (%s) - vazia", vaga.getId(), vaga.getTipo()));
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dadosVagas);
        listVagas.setAdapter(adapter);
    }

    private void carregarVagasOcupadas() {
        dadosVagas.clear();
        for (Map.Entry<Integer, Vaga> entry : listaDeVagas.getListaVagas().entrySet()) {
            Vaga vaga = entry.getValue();
            if (vaga.isOcupada()) {
                dadosVagas.add(String.format("%02d (%s) - ocupada por %s", vaga.getId(), vaga.getTipo(), vaga.getPlaca()));
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dadosVagas);
        listVagas.setAdapter(adapter);
    }
}
