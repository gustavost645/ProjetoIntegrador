/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.entity;

import br.com.l2g.audit.AgendaAudit;
import br.com.l2g.audit.ClienteAudit;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@EntityListeners(AgendaAudit.class)
@Entity
@SequenceGenerator(name = "AgendaSeq", sequenceName = "agenda_age_codigo_seq", allocationSize = 1)
@Table(name = "agenda")
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "AgendaSeq", strategy = GenerationType.SEQUENCE)
    @Column(name = "age_codigo")
    private Integer idAgenda;
    
    @OneToOne
    @JoinColumn(name = "age_cd_funcionario", referencedColumnName = "fun_codigo")
    private Funcionario funcionario;
    
    @OneToOne
    @JoinColumn(name = "age_cd_tipo",referencedColumnName = "tip_codigo")
    private Servico tipoServico;
    
    @OneToOne
    @JoinColumn(name = "age_cd_setor", referencedColumnName = "set_codigo")
    private Setor setorTrabalho;
    
    @OneToOne
    @JoinColumn(name = "age_cd_veiculo", referencedColumnName = "vei_codigo")
    private Veiculo veiculoCliente;
    
    @Column(name = "age_status")
    private Integer statusAgenda;
    
    @Column(name = "age_inicial")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataInicial;
    
    @Column(name = "age_final")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataFinal;

    


}
