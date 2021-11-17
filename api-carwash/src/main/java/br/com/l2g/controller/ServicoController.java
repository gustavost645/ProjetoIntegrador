/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.controller;

import br.com.l2g.entity.Servico;
import br.com.l2g.service.ServicoService;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gustavo Steinhoefel
 */
@RestController
@RequestMapping("/api/v1/servico")
@Slf4j
@AllArgsConstructor
public class ServicoController {

    private final ServicoService servicoService;

    @GetMapping
    public ResponseEntity<?> listarTodos() {
        try {
            List<Servico> lista = servicoService.listarTudo();
            log.info(lista.toString());
            return ResponseEntity.ok(lista);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Servico cliente) {
        try {
            servicoService.salvar(cliente);
            return ResponseEntity.ok(cliente);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
    
    @GetMapping("{id}")
    public ResponseEntity<?> listarPorID(@PathVariable("id") Integer idServico) {
        try {
            Optional<Servico> lista = servicoService.listarPorId(idServico);
            log.info(lista.toString());
            return ResponseEntity.ok(lista);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarServico(@PathVariable("id") Integer idServico) {
        try {
            log.info("Registro a ser deletado: "+idServico);
            servicoService.deletar(idServico);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
