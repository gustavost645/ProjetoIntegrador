/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.service;

import br.com.l2g.entity.Servico;
import br.com.l2g.repository.ServicoRepository;
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
public class ServicoService {
    
    private final ServicoRepository repository;

    public Servico salvar(Servico servico){
        return repository.save(servico);
    }

    public void deletar(Integer idServico){
        repository.deleteById(idServico);
    }

    public List<Servico> listarTudo(){
        return repository.findAll();
    }

    public Optional<Servico> listarPorId(Integer idServico) {
        return repository.findById(idServico);
    }

}
