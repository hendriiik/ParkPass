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

public class VagasEstacionamento extends AppCompatActivity {

    TextView txtTitulo;
    ImageButton btnCliente;
    Button btnHistorico, btnVagasVazias, btnVagasOcupadas;
    ListView listVagas;

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

        btnCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VagasEstacionamento.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnHistorico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtTitulo.getText().equals("Ocupação das vagas")) {
                    txtTitulo.setText("Histórico Vagas");
                } else {
                    txtTitulo.setText("Ocupação das vagas");
                }
            }
        });

        String[] exemplosDados = {"01 (moto) - vazia", "02 (moto) - ocupada por Biz GHZ-4932", "03 (carro) - vazia", "04 (carro) - vazia"};

        // Cria um adaptador para a lista
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, exemplosDados);

        // Define o adaptador para a ListView
        listVagas.setAdapter(adapter);

    }
}
