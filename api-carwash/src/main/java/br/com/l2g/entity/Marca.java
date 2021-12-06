/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.entity;

import br.com.l2g.audit.MarcaAudit;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@EntityListeners(MarcaAudit.class)
@SequenceGenerator(name = "MarcaSeq", sequenceName = "marcas_mar_codigo_seq", allocationSize = 1)
@Table(name = "marcas")
public class Marca implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "MarcaSeq", strategy = GenerationType.SEQUENCE)
    @Column(name="mar_codigo")
    private Integer idMarca;
    
    @Column(name="mar_nome")
    private String nomeMarca;    
}
