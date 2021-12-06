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
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Permissao implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer codigoPermissao;
    private String classeNome;
    private Boolean permissaoListar;
    private Boolean permissaoSalvar;
    private Boolean permissaoAlterar;
    private Boolean permissaoExcluir;

}
