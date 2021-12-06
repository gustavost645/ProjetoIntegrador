/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.service;

import br.com.l2g.entity.Veiculo;
import br.com.l2g.repository.VeiculoRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gustavo Steinhoefel
 */
@Service
@AllArgsConstructor
public class VeiculoService {

    private final VeiculoRepository repository;

    public Veiculo salvar(Veiculo veiculo) {
        return repository.save(veiculo);
    }

    public void deletar(Integer idVeiculo) {
        repository.deleteById(idVeiculo);
    }

    public List<Veiculo> listarTudo() {
        return repository.findAll();
    }

    public Optional<Veiculo> listarPorId(Integer idVeiculo) {
        return repository.findById(idVeiculo);
    }

}
