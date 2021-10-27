/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.service;

import br.com.l2g.entity.Funcionario;
import br.com.l2g.repository.FuncionarioRepository;
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
public class FuncionarioService {
    
    private final FuncionarioRepository repository;

    public Funcionario salvar(Funcionario funcionario){
        return repository.save(funcionario);
    }

    public void deletar(Integer idFuncionario){
        repository.deleteById(idFuncionario);
    }

    public List<Funcionario> listarTudo(){
        return repository.findAll();
    }

    public Optional<Funcionario> listarPorId(Integer idFuncionario) {
        return repository.findById(idFuncionario);
    }

}
