/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gsoftwares.telegram.model;

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
public class Cliente {
    private Integer idCliente;

    private String nome;

    private Cidade cidade;

    private String endereco;

    private String numero;

    private String complemento;

    private String bairro;

    private String cep;

    private String cpfCnpj;

    private String telefone;

    private String email;
}
