/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.model;
import java.util.Date;
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

public class Movimento {
    
    private Integer idMovimento;

    private String nomeCliente;
    
    private String placa;
    
    private String Tipo; 
    
    private String meioPagamento; 
    
    private Date data; 
    
    private String status; 

    private String observacao; 
    
}
