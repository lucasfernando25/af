
package com.example.ac2.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.example.ac2.model.Reserva;

public class VeiculoDTO {

    private long numero;
    private String descricao;
    private LocalDateTime dataVeiculo;
    private boolean veiculoFechado;
    private ArrayList<Reserva> itens = new ArrayList<Reserva>();
    private double totalVeiculo;

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {  
        this.descricao = descricao;
    }

    public LocalDateTime getDataVeiculo() {
        return dataVeiculo;
    }

    public void setDataVeiculo(LocalDateTime dataVeiculo) {
        this.dataVeiculo = dataVeiculo;
    }

    public boolean isVeiculoFechado() {
        return veiculoFechado;
    }

    public void setVeiculoFechado(boolean veiculoFechado) {
        this.veiculoFechado = veiculoFechado;
    }

    public ArrayList<Reserva> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Reserva> itens) {
        this.itens = itens;
    }

    public double getTotalVeiculo() {
        return totalVeiculo;
    }

    public void setTotalVeiculo(double totalVeiculo) {
        this.totalVeiculo = totalVeiculo;
    }
}