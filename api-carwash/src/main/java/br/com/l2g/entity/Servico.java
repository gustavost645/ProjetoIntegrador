/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.entity;

import br.com.l2g.audit.ServicoAudit;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
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
@EntityListeners(ServicoAudit.class)
@SequenceGenerator(name = "ServicoSeq", sequenceName = "tipo_servico_tip_codigo_seq", allocationSize = 1)
@Table(name = "tipo_servico")
public class Servico implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "ServicoSeq", strategy = GenerationType.SEQUENCE)
    @Column(name="tip_codigo")
    private Integer idServico;
    
    @Column(name="tip_nome")
    private String nomeServico;
}
