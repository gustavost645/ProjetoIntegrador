/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@SequenceGenerator(name = "GrupoPermissaoSeq", sequenceName = "grupo_permissao_codigo_seq", allocationSize = 1)
@Table(name = "grupo_permissao")
public class GrupoPermissao implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "GrupoPermissaoSeq", strategy = GenerationType.SEQUENCE)
    @Column(name="gru_codigo")
    private Integer codigoGrupoPermissao;
    
    @Column(name="gru_descricao")
    private String descricaoGrupoPermissao;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="per_grup_permission")
    private List<Permissao> listaPermissao;
    
    
}
