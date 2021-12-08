/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.service;

import br.com.l2g.entity.Agenda;
import br.com.l2g.repository.AgendaRepository;
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
public class AgendaService {
    
    private final AgendaRepository repository;

    public Agenda salvar(Agenda agenda){
        return repository.save(agenda);
    }

    public void deletar(Integer idAgenda){
        repository.deleteById(idAgenda);
    }

    public List<Agenda> listarTudo(){
        return repository.findAll();
    }

    public Optional<Agenda> listarPorId(Integer idAgenda) {
        return repository.findById(idAgenda);
    }

}
