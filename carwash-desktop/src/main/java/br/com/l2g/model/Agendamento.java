/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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

    private Integer idAgenda;

    private Funcionario funcionario;
    
    private Servicos tipoServico;
    
    private Setor setorTrabalho;
    
    private Veiculo veiculoCliente;

    private Status statusAgenda;
    
    private String dataInicial;

    private String dataFinal;
    
}
