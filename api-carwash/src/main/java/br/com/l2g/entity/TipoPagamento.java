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
@SequenceGenerator(name = "TipoPagamentoSeq", sequenceName = "tipo_pagamento_tip_codigo_seq", allocationSize = 1)
@Table(name = "tipo_pagamento")
public class TipoPagamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "TipoPagamentoSeq", strategy = GenerationType.SEQUENCE)
    @Column(name="tip_codigo")
    private Integer idTipoPagamento;
    
    @Column(name="tip_nome")
    private String nomeTipoPagamento;
}
