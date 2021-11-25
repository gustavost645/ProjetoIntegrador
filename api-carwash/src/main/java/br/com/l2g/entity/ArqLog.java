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
@SequenceGenerator(name = "LogSeq", sequenceName = "log_log_codigo_seq", allocationSize = 1)
@Table(name = "log")
public class ArqLog implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "LogSeq", strategy = GenerationType.SEQUENCE)
    @Column(name="log_codigo")
    private Integer idLog;
    
    @Column(name="log_descricao")
    private String descricaoLog;

    @Column(name="log_tabela")
    private String tabelaLog;

}
