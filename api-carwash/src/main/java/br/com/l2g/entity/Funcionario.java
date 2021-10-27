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

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "FuncionarioSeq", sequenceName = "funcionarios_fun_codigo_seq", allocationSize = 1)
@Table(name = "funcionarios")
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "FuncionarioSeq", strategy = GenerationType.SEQUENCE)
    @Column(name="fun_codigo")
    private Integer idFuncionario;
    
    @Column(name="fun_nome")
    private String nomeFuncionario;

}
