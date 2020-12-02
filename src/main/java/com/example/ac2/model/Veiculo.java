package com.example.ac2.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonGetter;

public class Veiculo {

    private long numero;
    private String modelo;
    private LocalDateTime dataVeiculo;
    private Cliente cliente;
    private boolean reservaFechado;
    private ArrayList<Reserva> itens = new ArrayList<Reserva>();

    public Veiculo() {

    }

    public Veiculo(long numero) {
        this.numero = numero;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDateTime getDataVeiculo() {
        return dataVeiculo;
    }

    public void setDataVeiculo(LocalDateTime dataVeiculo) {
        this.dataVeiculo = dataVeiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isReservaFechado() {
        return reservaFechado;
    }

    public void setVeiculoFechado(boolean veiculoFechado) {
        this.reservaFechado = veiculoFechado;
    }

    public ArrayList<Reserva> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Reserva> itens) {
        this.itens = itens;
    }

    public boolean addReserva(int numero, double preco, String produto, int quantidade) {
        return itens.add(new Reserva(numero, preco, produto, quantidade));
    }

    @JsonGetter
    public double totalReserva() {
        double total = 0;

        for (Reserva item : itens) {
            total += item.getTotalItem();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Veiculo [cliente=" + cliente.getId() + ", dataPedido=" + dataVeiculo + ", Modelo =" + modelo
                + ", numero=" + numero + "]";
    }
}
