/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Gustavo Steinhoefel
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "CidadesSeq", sequenceName = "cidades_cid_codigo_seq", allocationSize = 1)
@Table(name = "cidades")
public class Cidade implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "CidadesSeq", strategy = GenerationType.SEQUENCE)
    @Column(name="cid_codigo")
    private Integer idCidade;
    
    @Column(name="cid_nome")
    private String nomeCidade;
    
    @Column(name="cid_uf")
    private String ufEstado;
    
    /*@OneToMany
    private Cliente cliente;*/
    /*@OneToMany(mappedBy="clientes")
    private Set<Cliente> cliente;*/
    
    
            
    
}
