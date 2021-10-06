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
 * @author Gustavo Steinhoefel
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cidade {
    
    private Integer idCidade;

    private String nomeCidade;

    private String ufEstado;

}
