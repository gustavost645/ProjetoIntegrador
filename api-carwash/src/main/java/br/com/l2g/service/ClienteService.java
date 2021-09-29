/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.service;

import br.com.l2g.entity.Cliente;
import br.com.l2g.repository.ClienteRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gustavo Steinhoefel
 */
@Service
@AllArgsConstructor
public class ClienteService {
    
    private final ClienteRepository repository;

    public Cliente salvar(Cliente cliente){
        return repository.save(cliente);
    }

    public void deletar(Integer idCliente){
        repository.deleteById(idCliente);
    }

    public List<Cliente> listarTudo(){
        return repository.findAll();
    }

}
