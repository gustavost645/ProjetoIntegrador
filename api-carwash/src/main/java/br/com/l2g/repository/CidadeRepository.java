/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.repository;

import br.com.l2g.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gustavo Steinhoefel
 */
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
    
    @Query(value="SELECT * FROM cidades c WHERE c.cid_nome ilike %?1%",nativeQuery = true)
    Cidade findNomeCidade(String cidade);
    
}
