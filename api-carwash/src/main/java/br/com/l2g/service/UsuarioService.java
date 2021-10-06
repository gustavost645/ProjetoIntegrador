/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.service;

import br.com.l2g.entity.Usuario;
import br.com.l2g.repository.UsuarioRepository;
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
public class UsuarioService {
    
    private final UsuarioRepository repository;

    public Usuario salvar(Usuario cliente){
        return repository.save(cliente);
    }

    public void deletar(Integer idUsuario){
        repository.deleteById(idUsuario);
    }

    public List<Usuario> listarTudo(){
        return repository.findAll();
    }

    public Optional<Usuario> listarPorId(Integer idUsuario) {
        return repository.findById(idUsuario);
    }
    
    

}
