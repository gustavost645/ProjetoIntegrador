
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

public class FluxoDeCaixa {
    
    private Integer idPagamento;
    private String tipo;
    private String data;
    private String valor;
    private String nome;

 

 

   
    
    
}
