/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.service;

import br.com.l2g.entity.TipoPagamento;
import br.com.l2g.repository.TipoPagamentoRepository;
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
public class TipoPagamentoService {
    
    private final TipoPagamentoRepository repository;

    public TipoPagamento salvar(TipoPagamento tipPagamento){
        return repository.save(tipPagamento);
    }

    public void deletar(Integer idTipoPagamento){
        repository.deleteById(idTipoPagamento);
    }

    public List<TipoPagamento> listarTudo(){
        return repository.findAll();
    }

    public Optional<TipoPagamento> listarPorId(Integer idTipoPagamento) {
        return repository.findById(idTipoPagamento);
    }

}
