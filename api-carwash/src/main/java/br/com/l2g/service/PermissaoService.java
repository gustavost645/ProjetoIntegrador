/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.service;

import br.com.l2g.entity.Permissao;
import br.com.l2g.repository.PermissaoRepository;
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
public class PermissaoService {
    
    private final PermissaoRepository repository;

    public Permissao salvar(Permissao permissao){
        return repository.save(permissao);
    }

    public void deletar(Integer idPermissao){
        repository.deleteById(idPermissao);
    }

    public List<Permissao> listarTudo(){
        return repository.findAll();
    }

    public Optional<Permissao> listarPorId(Integer idPermissao) {
        return repository.findById(idPermissao);
    }

}
