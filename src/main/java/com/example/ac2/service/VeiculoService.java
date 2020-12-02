package com.example.ac2.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.ac2.dto.VeiculoDTO;
import com.example.ac2.model.Cliente;
import com.example.ac2.model.Veiculo;
import com.example.ac2.repository.VeiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repositorio;

    @Autowired
    private ClienteService clienteService;

    public VeiculoDTO toDTO(Veiculo veiculo) {

        VeiculoDTO dto = new VeiculoDTO();

        dto.setDataVeiculo(veiculo.getDataVeiculo());
        dto.setDescricao(veiculo.getModelo());
        dto.setItens(veiculo.getItens());
        dto.setNumero(veiculo.getNumero());
        dto.setVeiculoFechado(veiculo.isReservaFechado());
        dto.setTotalVeiculo(veiculo.totalReserva());
        return dto;
    }

    public List<VeiculoDTO> toListDTO(List<Veiculo> veiculos) {
        ArrayList<VeiculoDTO> dtoList = new ArrayList<VeiculoDTO>();

        for (Veiculo veiculo : veiculos) {
            dtoList.add(toDTO(veiculo));
        }

        return dtoList;
    }

    public List<Veiculo> getAllVeiculos() {
        return repositorio.getAllVeiculos();
    }

    public Veiculo getVeiculoByNumero(long numero) {
        Optional<Veiculo> op = repositorio.getVeiculoByNumero(numero);
        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veiculo nao cadastrado"));
    }

    public Veiculo salvar(Veiculo veiculo, int idCliente) {

        // Verificar se existe o idCliente, senao existir 404 NotFound
        // Se lancar o 404, finaliza o metodo salvar Veiculo
        Cliente cliente = clienteService.getClienteById(idCliente);

        veiculo.setDataVeiculo(LocalDateTime.now());

        // Associar um veiculo ao cliente e um cliente ao veiculo
        veiculo.setCliente(cliente);
        cliente.addVeiculo(veiculo);

        return repositorio.salvar(veiculo);
    }

}
