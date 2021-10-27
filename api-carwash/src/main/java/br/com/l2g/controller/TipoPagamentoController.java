/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.controller;

import br.com.l2g.entity.TipoPagamento;
import br.com.l2g.service.TipoPagamentoService;
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
@RequestMapping("/api/v1/tipoPagamento")
@Slf4j
@AllArgsConstructor
public class TipoPagamentoController {

    private final TipoPagamentoService tipoPagamentoService;

    @GetMapping
    public ResponseEntity<?> listarTodos() {
        try {
            List<TipoPagamento> lista = tipoPagamentoService.listarTudo();
            log.info(lista.toString());
            return ResponseEntity.ok(lista);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody TipoPagamento tipoPagamento) {
        try {
            tipoPagamentoService.salvar(tipoPagamento);
            return ResponseEntity.ok(tipoPagamento);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
    
    @GetMapping("{id}")
    public ResponseEntity<?> listarPorID(@PathVariable("id") Integer idTipoPagamento) {
        try {
            Optional<TipoPagamento> lista = tipoPagamentoService.listarPorId(idTipoPagamento);
            log.info(lista.toString());
            return ResponseEntity.ok(lista);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarTipoPagamento(@PathVariable("id") Integer idTipoPagamento) {
        try {
            log.info("Registro a ser deletado: "+idTipoPagamento);
            tipoPagamentoService.deletar(idTipoPagamento);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
