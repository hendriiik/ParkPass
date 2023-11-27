package com.example.parkpass;

public class Vaga {
    private int id;
    private String tipo, placa;
    private boolean ocupada;

    public static String MOTO = "MOTO";
    public static String CARRO = "CARRO";

    public Vaga(int id, String tipo, String placa, boolean ocupada) {
        this.id = id;
        this.tipo = tipo;
        this.placa = placa;
        this.ocupada = ocupada;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
}
