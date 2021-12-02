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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "PermissaoSeq", sequenceName = "permissao_per_codigo_seq", allocationSize = 1)
@Table(name = "permissao")
public class Permissao implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "PermissaoSeq", strategy = GenerationType.SEQUENCE)
    @Column(name="per_codigo")
    private Integer codigoPermissao;
    
    @Column(name="per_class_name")
    private String classeNome;
    
    @Column(name="per_grup_permission")
    private Integer codigoGrupoPermissao;
    
    @Column(name="per_list")
    private Boolean permissaoListar;
    
    @Column(name="per_save")
    private Boolean permissaoSalvar;
    
    @Column(name="per_edit")
    private Boolean permissaoAlterar;
    
    @Column(name="per_delete")
    private Boolean permissaoExcluir;
   
  
}