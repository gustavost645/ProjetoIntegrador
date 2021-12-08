/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.controller;

import br.com.l2g.entity.Status;
import br.com.l2g.service.StatusService;
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
@RequestMapping("/api/v1/status")
@Slf4j
@AllArgsConstructor
public class StatusController {

    private final StatusService statusService;

    @GetMapping
    public ResponseEntity<?> listarTodos() {
        try {
            List<Status> lista = statusService.listarTudo();
            log.info(lista.toString());
            return ResponseEntity.ok(lista);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Status cliente) {
        try {
            statusService.salvar(cliente);
            return ResponseEntity.ok(cliente);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
    
    @GetMapping("{id}")
    public ResponseEntity<?> listarPorID(@PathVariable("id") Integer idStatus) {
        try {
            Optional<Status> lista = statusService.listarPorId(idStatus);
            log.info(lista.toString());
            return ResponseEntity.ok(lista);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarStatus(@PathVariable("id") Integer idStatus) {
        try {
            log.info("Registro a ser deletado: "+idStatus);
            statusService.deletar(idStatus);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
