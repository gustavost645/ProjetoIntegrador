/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Gustavo Steinhoefel
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idCliente;

    private String nome;

    private Integer idCidade;

    private String endereco;

    private String numero;

    private String complemento;

    private String bairro;

    private String cep;

    private String cpfCnpj;

    private String telefone;

    private String email;

}
