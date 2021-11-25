/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.service;

import br.com.l2g.entity.ArqLog;
import br.com.l2g.entity.Cliente;
import br.com.l2g.repository.ArqLogRepository;
import br.com.l2g.repository.ClienteRepository;
import br.com.l2g.util.Email;
import com.sun.tools.sjavac.Log;
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
public class ClienteService {
    
    private final ClienteRepository repository;
    private final ArqLogRepository arqrepository;

    public Cliente salvar(Cliente cliente){
        
        if (!cliente.getEmail().equals("")) {
            Email email = new Email();            
            email.sendSimpleMessage(cliente.getEmail(), "Cadastro Car Wash", "Olá " + cliente.getNome() +  "! \nSeu cadastro foi realizado com sucesso em nossa empresa! \nPara maiores informações, \nTelegram (99) 99998888");
        }
        
        return repository.save(cliente);
    }

    public void deletar(Integer idCliente){
        repository.deleteById(idCliente);
    }

    public List<Cliente> listarTudo(){
        return repository.findAll();
    }

    public Optional<Cliente> listarPorId(Integer idCliente) {
        return repository.findById(idCliente);
    }

    public void salvarLog(ArqLog log) {
        Log.info("cheguei aqui");
        //arqrepository.save(log);
    }

}
