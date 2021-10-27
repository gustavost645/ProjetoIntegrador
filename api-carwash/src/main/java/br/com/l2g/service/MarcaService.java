/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.service;

import br.com.l2g.entity.Marca;
import br.com.l2g.repository.MarcaRepository;
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
public class MarcaService {
    
    private final MarcaRepository repository;

    public Marca salvar(Marca marca){
        return repository.save(marca);
    }

    public void deletar(Integer idMarca){
        repository.deleteById(idMarca);
    }

    public List<Marca> listarTudo(){
        return repository.findAll();
    }

    public Optional<Marca> listarPorId(Integer idMarca) {
        return repository.findById(idMarca);
    }

}
