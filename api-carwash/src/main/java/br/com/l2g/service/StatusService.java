/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.service;

import br.com.l2g.entity.Status;
import br.com.l2g.repository.StatusRepository;
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
public class StatusService {
    
    private final StatusRepository repository;

    public Status salvar(Status status){
        return repository.save(status);
    }

    public void deletar(Integer idStatus){
        repository.deleteById(idStatus);
    }

    public List<Status> listarTudo(){
        return repository.findAll();
    }

    public Optional<Status> listarPorId(Integer idStatus) {
        return repository.findById(idStatus);
    }

}
