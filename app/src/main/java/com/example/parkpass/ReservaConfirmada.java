package com.example.parkpass;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReservaConfirmada extends AppCompatActivity {

    TextView txtTempoChegarLocal;
    Button btnChegueiAoEstacionamento, btnAbrirMapa;

    ImageButton btnVoltar;

    Integer segundos;
    CountDownTimer countDownTimer;
    ProgressBar pbTempoChegada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reserva_confirmada);

        txtTempoChegarLocal = findViewById(R.id.txtTempoChegarLocal);
        btnChegueiAoEstacionamento = findViewById(R.id.btnChegueiAoEstacionamento);
        btnAbrirMapa = findViewById(R.id.btnAbrirMapa);
        btnVoltar = findViewById(R.id.btnVoltar);
        pbTempoChegada = findViewById(R.id.pbTempoChegada);

        txtTempoChegarLocal.setText("15:00 para chegar ao local");

        segundos = 15*60;

        btnChegueiAoEstacionamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReservaConfirmada.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        countDownTimer = new CountDownTimer(segundos*1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Atualiza o texto do contador a cada segundo
                long segundosRestantes = millisUntilFinished / 1000;
                Integer porcentagem = (int) segundosRestantes / segundos;
                porcentagem = 100 - porcentagem;
                pbTempoChegada.setProgress(porcentagem);
                String tempoRestante = segundosRestantes/60 + ":" + segundosRestantes%60;
                txtTempoChegarLocal.setText(tempoRestante + " para chegar ao local");
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(ReservaConfirmada.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };

        btnAbrirMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirGoogleMaps(ReservaConfirmada.this);
            }
        });

        countDownTimer.start();

    }

    public static void abrirGoogleMaps(Context context) {
        Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("google.navigation:q=estacionamento"));
        context.startActivity(mapIntent);
    }
}
