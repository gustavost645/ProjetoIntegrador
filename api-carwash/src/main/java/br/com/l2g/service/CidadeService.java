/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.service;

import br.com.l2g.entity.Cidade;
import br.com.l2g.repository.CidadeRepository;
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
public class CidadeService {
    
    private final CidadeRepository repository;

    public Cidade salvar(Cidade cliente){
        return repository.save(cliente);
    }

    public void deletar(Integer idCidade){
        repository.deleteById(idCidade);
    }

    public List<Cidade> listarTudo(){
        return repository.findAll();
    }

    
    public Optional<Cidade> listarPorId(Integer idCidade) {
        return repository.findById(idCidade);
    }

    public Cidade buscaPorNome(String nome) {
        return repository.findNomeCidade(nome);
    }
}
