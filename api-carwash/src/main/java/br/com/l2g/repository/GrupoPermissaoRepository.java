/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.repository;

import br.com.l2g.entity.GrupoPermissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gustavo Steinhoefel
 */
@Repository
public interface GrupoPermissaoRepository extends JpaRepository<GrupoPermissao, Integer> {
    
}
