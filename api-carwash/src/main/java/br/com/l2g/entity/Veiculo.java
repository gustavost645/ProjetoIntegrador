/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.entity;

import br.com.l2g.audit.VeiculoAudit;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Entity
@EntityListeners(VeiculoAudit.class)                   
@SequenceGenerator(name = "VeiculoSeq", sequenceName = "veiculos_vei_codigo_seq", allocationSize = 1)
@Table(name = "veiculos")
public class Veiculo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "VeiculoSeq", strategy = GenerationType.SEQUENCE)
    @Column(name="vei_codigo")
    private Integer idVeiculo;
    
    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name="vei_cd_marca", nullable=false)
    @OneToOne()
    @JoinColumn(name="vei_cd_marca", referencedColumnName = "mar_codigo")    
    private Marca marca;   
    
    @Column(name="vei_placa")
    private String placa;
    
    
    //@JsonManagedReference
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "controle_veiculos", 
            joinColumns = {@JoinColumn(name = "con_cd_veiculo")},
            inverseJoinColumns = {@JoinColumn(name = "con_cd_cliente")})
    private List<Cliente> cliente;

}
