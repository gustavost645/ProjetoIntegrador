/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.service;

import br.com.l2g.entity.GrupoPermissao;
import br.com.l2g.repository.GrupoPermissaoRepository;
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
public class GrupoPermissaoService {
    
    private final GrupoPermissaoRepository repository;

    public GrupoPermissao salvar(GrupoPermissao grupoPermissao){
        return repository.save(grupoPermissao);
    }

    public void deletar(Integer idGrupoPermissao){
        repository.deleteById(idGrupoPermissao);
    }

    public List<GrupoPermissao> listarTudo(){
        return repository.findAll();
    }

    
    public Optional<GrupoPermissao> listarPorId(Integer idGrupoPermissao) {
        return repository.findById(idGrupoPermissao);
    }

}
