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

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DetalhesEstacionamentoActivity extends AppCompatActivity {

    ImageView imgFtEstacionamento, imgEletrico, imgMoto, imgCoberto, imgAcessivel, imgBemAvaliado;
    TextView txtNota, txtNomeEstacionamento, txtFuncionamentoValor, txtPreco;
    Button btnCancelar, btnReservar;
    ImageButton btnVoltar;
    Estacionamento estacionamento;

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
                voltar();
            }
        });

        btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibirConfirmarReservaDialog();
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            int estacionamentoId = intent.getIntExtra("estacionamentoId", -1);

            // Verifica se o ID do estacionamento foi passado corretamente
            if (estacionamentoId != -1) {
                // Obtém o estacionamento da lista usando o ID
                ListaDeEstacionamentos listaDeEstacionamentos = new ListaDeEstacionamentos();
                listaDeEstacionamentos.carregarEstacionamentos();
                estacionamento = listaDeEstacionamentos.selecionaEstacionamentoPorId(estacionamentoId);

                // Preenche os componentes da interface com os dados do estacionamento
                if (estacionamento != null) {
                    preencherDetalhesEstacionamento(estacionamento);
                }
            }
        }

        //todo esconder/exibir icones
        //todo exibir imagem do estacionamento

    }

    private void voltar() {
        onBackPressed();
    }

    private void preencherDetalhesEstacionamento(Estacionamento estacionamento) {
        txtNomeEstacionamento.setText(estacionamento.getNome());
        txtNota.setText(Float.toString(estacionamento.getNota()));
        txtFuncionamentoValor.setText(estacionamento.getFuncionamento());
        txtPreco.setText("Preço: "+formatarValorEmReais((double) estacionamento.getPreco()));
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

        txtNomeEstacionamento.setText(estacionamento.getNome());
        txtValor.setText(formatarValorEmReais((double) estacionamento.getPreco()));

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 15);
        String horarioInicio = formatarHorario(calendar);

        // Adiciona mais 1 hora
        calendar.add(Calendar.HOUR_OF_DAY, 1);
        String horarioFim = formatarHorario(calendar);

        // Exibe o intervalo de horários no TextView
        String intervaloHorario = horarioInicio + " - " + horarioFim;
        txtHorario.setText(intervaloHorario);

        btnSim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalhesEstacionamentoActivity.this, ReservaConfirmadaActivity.class);
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

    private String formatarHorario(Calendar calendar) {
        // Formata o horário como XX:XX
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
        return sdf.format(calendar.getTime());
    }

    private String formatarValorEmReais(double valor) {
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return formatoMoeda.format(valor);
    }
}

