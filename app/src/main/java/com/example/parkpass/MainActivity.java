package com.example.parkpass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ImageButton btnProcurarEstacionamento, btnModoEstacionamento;
    ImageButton btnVoltar;
    ConstraintLayout lay1Km, layEletrico, layMotos, layAcessivel, layBemAvaliado;
    ImageView imgFtEstacionamento1, imgFtEstacionamento2, imgFtEstacionamento3, imgFtEstacionamento4, imgFtEstacionamento5;
    AutoCompleteTextView etSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnProcurarEstacionamento = findViewById(R.id.btnSearch);
        btnModoEstacionamento = findViewById(R.id.btnEstacionamento);
        btnVoltar = findViewById(R.id.btnVoltar);
        lay1Km = findViewById(R.id.lay1Km);
        layEletrico = findViewById(R.id.layEletrico);
        layMotos = findViewById(R.id.layMotos);
        layAcessivel = findViewById(R.id.layAcessivel);
        layBemAvaliado = findViewById(R.id.layBemAvaliado);
        imgFtEstacionamento1 = findViewById(R.id.imgFtEstacionamento1);
        imgFtEstacionamento2 = findViewById(R.id.imgFtEstacionamento2);
        imgFtEstacionamento3 = findViewById(R.id.imgFtEstacionamento3);
        imgFtEstacionamento4 = findViewById(R.id.imgFtEstacionamento4);
        imgFtEstacionamento5 = findViewById(R.id.imgFtEstacionamento5);
        etSearch = findViewById(R.id.etSearch);


        btnProcurarEstacionamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(MainActivity.this, DetalhesEstacionamentoActivity.class);
                startActivity(intent);
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        lay1Km.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgFtEstacionamento1.setVisibility(View.GONE);
                imgFtEstacionamento2.setVisibility(View.VISIBLE);
                imgFtEstacionamento3.setVisibility(View.GONE);
                imgFtEstacionamento4.setVisibility(View.GONE);
                imgFtEstacionamento5.setVisibility(View.GONE);
            }
        });

        layAcessivel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgFtEstacionamento1.setVisibility(View.VISIBLE);
                imgFtEstacionamento2.setVisibility(View.GONE);
                imgFtEstacionamento3.setVisibility(View.GONE);
                imgFtEstacionamento4.setVisibility(View.VISIBLE);
                imgFtEstacionamento5.setVisibility(View.VISIBLE);
            }
        });

        layMotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgFtEstacionamento1.setVisibility(View.VISIBLE);
                imgFtEstacionamento2.setVisibility(View.VISIBLE);
                imgFtEstacionamento3.setVisibility(View.GONE);
                imgFtEstacionamento4.setVisibility(View.GONE);
                imgFtEstacionamento5.setVisibility(View.GONE);
            }
        });

        layBemAvaliado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgFtEstacionamento1.setVisibility(View.GONE);
                imgFtEstacionamento2.setVisibility(View.VISIBLE);
                imgFtEstacionamento3.setVisibility(View.GONE);
                imgFtEstacionamento4.setVisibility(View.VISIBLE);
                imgFtEstacionamento5.setVisibility(View.GONE);
            }
        });

        layEletrico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgFtEstacionamento1.setVisibility(View.VISIBLE);
                imgFtEstacionamento2.setVisibility(View.GONE);
                imgFtEstacionamento3.setVisibility(View.GONE);
                imgFtEstacionamento4.setVisibility(View.GONE);
                imgFtEstacionamento5.setVisibility(View.GONE);
            }
        });

        btnModoEstacionamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VagasEstacionamento.class);
                startActivity(intent);
            }
        });

        String[] exemploTextos = {"estacionamento 1", "estacionamento 2", "estacionamento 3"};


// Cria um adaptador para o AutoCompleteTextView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, exemploTextos);

// Define o adaptador para o AutoCompleteTextView
        etSearch.setAdapter(adapter);

        etSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Obtém o item selecionado
                String selectedItem = (String) parent.getItemAtPosition(position);

                // Abre a nova tela (substitua DetalhesEstacionamentoActivity.class pela sua Activity desejada)
                Intent intent = new Intent(MainActivity.this, DetalhesEstacionamentoActivity.class);
                // Você também pode passar dados para a próxima Activity se necessário
                intent.putExtra("selectedItem", selectedItem);
                startActivity(intent);
            }
        });

    }
}