/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.entity;

import br.com.l2g.audit.VeiculoAudit;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@EntityListeners(VeiculoAudit.class)
@SequenceGenerator(name = "VeiculoSeq", sequenceName = "veiculos_vei_codigo_seq", allocationSize = 1)
@Table(name = "veiculos")
public class Veiculo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "VeiculoSeq", strategy = GenerationType.SEQUENCE)
    @Column(name="vei_codigo")
    private Integer idVeiculos;
    
    @ManyToOne
    @JoinColumn(name="vei_cd_marca", nullable=false)
    private Marca marca;
    
    @Column(name="vei_placa")
    private String placa;

}
