/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.controller;

import br.com.l2g.entity.Agenda;
import br.com.l2g.service.AgendaService;
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
@RequestMapping("/api/v1/agenda")
@Slf4j
@AllArgsConstructor
public class AgendaController {

    private final AgendaService agendaService;

    @GetMapping
    public ResponseEntity<?> listarTodos() {
        try {
            List<Agenda> lista = agendaService.listarTudo();
            log.info(lista.toString());
            return ResponseEntity.ok(lista);
        } catch (Exception ex) {
            log.info(ex.getMessage());
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Agenda agenda) {
        try {
            log.info(agenda.toString());
            agendaService.salvar(agenda);
            return ResponseEntity.ok(agenda);
        } catch (Exception ex) {
            log.info(ex.getMessage());
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
    
    @GetMapping("{id}")
    public ResponseEntity<?> listarPorID(@PathVariable("id") Integer idAgenda) {
        try {
            Optional<Agenda> lista = agendaService.listarPorId(idAgenda);
            log.info(lista.toString());
            return ResponseEntity.ok(lista);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarAgenda(@PathVariable("id") Integer idAgenda) {
        try {
            log.info("Registro a ser deletado: "+idAgenda);
            agendaService.deletar(idAgenda);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
