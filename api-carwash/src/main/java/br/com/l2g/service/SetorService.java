/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.service;

import br.com.l2g.entity.Setor;
import br.com.l2g.repository.SetorRepository;
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
public class SetorService {
    
    private final SetorRepository repository;

    public Setor salvar(Setor setor){
        return repository.save(setor);
    }

    public void deletar(Integer idSetor){
        repository.deleteById(idSetor);
    }

    public List<Setor> listarTudo(){
        return repository.findAll();
    }

    public Optional<Setor> listarPorId(Integer idSetor) {
        return repository.findById(idSetor);
    }

}
