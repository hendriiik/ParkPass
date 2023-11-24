package com.example.parkpass;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class DetalhesEstacionamentoActivity extends AppCompatActivity {

    ImageView imgFtEstacionamento, imgEletrico, imgMoto, imgCoberto, imgAcessivel, imgBemAvaliado;
    TextView txtNota, txtNomeEstacionamento, txtDistanciaValor, txtFuncionamentoValor, txtPreco;
    Button btnCancelar, btnReservar;
    ImageButton btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhes_estacionamento);

        imgFtEstacionamento = findViewById(R.id.imgFtEstacionamento);

        imgEletrico = findViewById(R.id.imgEletrico);
        imgMoto = findViewById(R.id.imgMoto);
        imgCoberto = findViewById(R.id.imgCoberto);
        imgAcessivel = findViewById(R.id.imgAcessivel);
        imgBemAvaliado = findViewById(R.id.imgBemAvaliado);

        txtNota = findViewById(R.id.txtNota);
        txtNomeEstacionamento = findViewById(R.id.txtNomeEstacionamento);
        txtDistanciaValor = findViewById(R.id.txtDistanciaValor);
        txtFuncionamentoValor = findViewById(R.id.txtFuncionamentoValor);
        txtPreco = findViewById(R.id.txtPreco);

        btnVoltar = findViewById(R.id.btnVoltar);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnReservar = findViewById(R.id.btnReservar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voltar();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo colocar uma intent
                voltar();
            }
        });

        btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibirConfirmarReservaDialog();
            }
        });


        //todo esconder/exibir icones
        //todo exibir imagem do estacionamento
        //todo exibir os textos corretamente

    }

    private void voltar() {
        onBackPressed();
    }


    private void exibirConfirmarReservaDialog() {
        AlertDialog.Builder builder;
        final AlertDialog alertDialog;
        builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.dialog_confirmar_reserva, null);
        builder.setView(view);
        alertDialog = builder.create();

        TextView txtNomeEstacionamento = view.findViewById(R.id.txtNomeEstacionamento);
        TextView txtValor = view.findViewById(R.id.txtValor);
        TextView txtHorario = view.findViewById(R.id.txtHorario);
        AppCompatButton btnSim = view.findViewById(R.id.btnSim);
        AppCompatButton btnNao = view.findViewById(R.id.btnNao);

        //todo popular esses txts

        btnSim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalhesEstacionamentoActivity.this, ReservaConfirmada.class);
                startActivity(intent);
                finish();
            }
        });

        btnNao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        alertDialog.show();
    }
}

