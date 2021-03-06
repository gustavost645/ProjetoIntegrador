/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.entity;

import br.com.l2g.audit.UsuarioAudit;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@EntityListeners(UsuarioAudit.class)
@SequenceGenerator(name = "UsuarioSeq", sequenceName = "usuarios_usr_codigo_seq", allocationSize = 1)
@Table(name = "usuarios")
public class Usuario implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UsuarioSeq", strategy = GenerationType.SEQUENCE)
    @Column(name="usr_codigo")
    private Integer idUsuario;
    
    @Column(name="usr_name")
    private String nome;
    
    
    @Column(name="usr_login")
    private String login;
    
    
    @Column(name="usr_senha")
    private String senha;
    
    @OneToOne()
    @JoinColumn(name="usr_group_permission", referencedColumnName = "gru_codigo")
    private GrupoPermissao grupoPermissao;
  
}
