package com.example.ac2.controller;

import java.util.List;

import com.example.ac2.model.Veiculo;
import com.example.ac2.service.VeiculoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @GetMapping
    public List<Veiculo> getAllVeiculos() {
        return service.getAllVeiculos();
    }

    @GetMapping("/{numero}")
    public ResponseEntity<Veiculo> getVeiculoByNumero(@PathVariable long numero) {
        Veiculo veiculo = service.getVeiculoByNumero(numero);
        return ResponseEntity.ok(veiculo);
    }

}
