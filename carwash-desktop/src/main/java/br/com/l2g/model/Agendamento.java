/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.model;

import javax.print.attribute.DateTimeSyntax;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author lucas
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Agendamento {

    private Integer idAgendamento;
    private Integer idFuncionario;
    private Integer idTipo;
    private Integer idSetor;
    private DateTimeSyntax DataInicial;
    private DateTimeSyntax DataFinal;

    // private String nomeCidade;
}
