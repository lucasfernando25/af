package com.example.ac2.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Cliente {
    private int id;
    private String nome;
    private String endereco;
    private String CPF;

    @JsonIgnore
    private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(ArrayList<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public boolean addVeiculo(Veiculo veiculo) {
        return veiculos.add(veiculo);
    }

    public boolean removeVeiculo(Veiculo veiculo) {
        return veiculos.remove(veiculo);
    }

    public double somaTotalReservas() {
        double soma = 0;

        for (Veiculo veiculo : veiculos) {
            soma += veiculo.totalReserva();
        }

        return soma;
    }

    public double somaTotalReservasFechados() {
        double soma = 0;

        for (Veiculo veiculo : veiculos) {
            if (veiculo.isReservaFechado()) {
                soma += veiculo.totalReserva();
            }
        }

        return soma;
    }

}
