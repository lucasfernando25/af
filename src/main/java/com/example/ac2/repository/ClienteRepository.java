package com.example.ac2.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import com.example.ac2.model.Cliente;
import com.example.ac2.model.Reserva;

import org.springframework.stereotype.Component;

@Component
public class ClienteRepository {

    private List<Cliente> clientes;
    private List<Reserva> reservas;
    private int nextId;

    @PostConstruct
    public void init() {
        Cliente c1 = new Cliente();
        c1.setId(1);
        c1.setNome("Paulo");
        c1.setEndereco("Rua cinco, 234");
        c1.setCPF("168.960.748-69");

        Cliente c2 = new Cliente();
        c2.setId(2);
        c2.setNome("Pedro");
        c2.setEndereco("Rua um, 23");
        c2.setCPF("258.568.748-69");

        Cliente c3 = new Cliente();
        c3.setId(3);
        c3.setNome("Joao");
        c3.setEndereco("Rua a, 21");
        c3.setCPF("368.560.748-69");

        clientes = new ArrayList<Cliente>();
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);
        nextId = 4;

    }

    public List<Cliente> getAllClientes() {
        return clientes;
    }

    public Optional<Cliente> getClienteById(int id) {
        for (Cliente aux : clientes) {
            if (aux.getId() == id) {
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Optional<Reserva> getReservaByNumero(int numero) {
        for (Reserva reservas : reservas) {
            if (reservas.getNumero() == numero) {
                return Optional.of(reservas);
            }
        }
        return Optional.empty();
    }

    

    public Cliente salvar(Cliente cliente) {
        cliente.setId(nextId++);
        clientes.add(cliente);
        return cliente;
    }

    public void remove(Cliente cli) {
        clientes.remove(cli);
    }

    public Cliente update(Cliente cliente) {

        Cliente aux = getClienteById(cliente.getId()).get();

        if (aux != null) {
            aux.setEndereco(cliente.getEndereco());
            aux.setNome(cliente.getNome());
        }

        return aux;

    }

}
