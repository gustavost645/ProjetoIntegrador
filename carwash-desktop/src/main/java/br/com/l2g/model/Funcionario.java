/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author lucas
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {
    
    private Integer idFuncionario;
    private String nome;

}
