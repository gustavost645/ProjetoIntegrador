/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.controller;

import br.com.l2g.entity.Usuario;
import br.com.l2g.service.UsuarioService;
import br.com.l2g.util.Status;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
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
@RequestMapping("/api/v1/usuario")
@Slf4j
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<?> listarTodos() {
        try {
            List<Usuario> lista = usuarioService.listarTudo();
            log.info(lista.toString());
            return ResponseEntity.ok(lista);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Usuario usuario) {
        try {
            usuarioService.salvar(usuario);
            return ResponseEntity.ok(usuario);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> listarPorID(@PathVariable("id") Integer idUsuario) {
        try {
            Optional<Usuario> lista = usuarioService.listarPorId(idUsuario);
            log.info(lista.toString());
            return ResponseEntity.ok(lista);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable("id") Integer idUsuario) {
        try {
            log.info("Registro a ser deletado: " + idUsuario);
            usuarioService.deletar(idUsuario);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/login")
    public Status loginUser(@Valid @RequestBody Usuario user) {
        List<Usuario> users = usuarioService.listarTudo();
        for (Usuario other : users) {
            if (other.getLogin().equals(user.getLogin()) && other.getSenha().equals(user.getSenha())) {
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }
    
    @GetMapping("/login/{login}")
    public ResponseEntity<?> listarPorUser(@PathVariable("login") String idUsuario) {
        try {
            Usuario lista = usuarioService.listarPorLogin(idUsuario);
            log.info(lista.toString());
            return ResponseEntity.ok(lista);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
