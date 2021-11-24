/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.entity;

import br.com.l2g.audit.SetorAudit;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
@EntityListeners(SetorAudit.class)
@SequenceGenerator(name = "SetorSeq", sequenceName = "setor_set_codigo_seq", allocationSize = 1)
public class Setor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "SetorSeq", strategy = GenerationType.SEQUENCE)
    @Column(name="set_codigo")
    private Integer idSetor;
    
    @Column(name="set_nome")
    private String nomeSetor;
}
