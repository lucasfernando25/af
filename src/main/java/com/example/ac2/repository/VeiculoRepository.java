package com.example.ac2.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.example.ac2.model.Veiculo;

import org.springframework.stereotype.Component;

@Component
public class VeiculoRepository {

    private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
    private static int nextNumero = 1;

    public List<Veiculo> getAllVeiculos() {
        return veiculos;
    }

    @PostConstruct
    public void init() {
        Veiculo v1 = new Veiculo();
        v1.setNumero(1);
        v1.setModelo("Gol");
        

        Veiculo v2 = new Veiculo();
        v2.setNumero(2);
        v2.setModelo("Palio");
        

        Veiculo v3 = new Veiculo();
        v3.setNumero(3);
        v3.setModelo("Polo");
        

        veiculos = new ArrayList<Veiculo>();
        veiculos.add(v1);
        veiculos.add(v2);
        veiculos.add(v3);
        nextNumero = 4;
    }

    public Optional<Veiculo> getVeiculoByNumero(long numero) {
        for (Veiculo aux : veiculos) {
            if (aux.getNumero() == numero) {
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Veiculo salvar(Veiculo veiculo) {
        veiculo.setNumero(nextNumero++);
        veiculos.add(veiculo);
        return veiculo;
    }
}
