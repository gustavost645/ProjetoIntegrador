/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.controller;

import br.com.l2g.entity.Funcionario;
import br.com.l2g.service.FuncionarioService;
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
@RequestMapping("/api/v1/funcionario")
@Slf4j
@AllArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<?> listarTodos() {
        try {
            List<Funcionario> lista = funcionarioService.listarTudo();
            log.info(lista.toString());
            return ResponseEntity.ok(lista);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Funcionario funcionario) {
        try {
            funcionarioService.salvar(funcionario);
            return ResponseEntity.ok(funcionario);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
    
    @GetMapping("{id}")
    public ResponseEntity<?> listarPorID(@PathVariable("id") Integer idFuncionario) {
        try {
            Optional<Funcionario> lista = funcionarioService.listarPorId(idFuncionario);
            log.info(lista.toString());
            return ResponseEntity.ok(lista);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarFuncionario(@PathVariable("id") Integer idFuncionario) {
        try {
            log.info("Registro a ser deletado: "+idFuncionario);
            funcionarioService.deletar(idFuncionario);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
