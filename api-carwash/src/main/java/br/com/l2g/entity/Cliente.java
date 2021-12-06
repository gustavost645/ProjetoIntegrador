/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.entity;

import br.com.l2g.audit.ClienteAudit;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@EntityListeners(ClienteAudit.class)
@Entity
@SequenceGenerator(name = "ClienteSeq", sequenceName = "clientes_cli_codigo_seq", allocationSize = 1)
@Table(name = "clientes")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "ClienteSeq", strategy = GenerationType.SEQUENCE)
    @Column(name = "cli_codigo")
    private Integer idCliente;

    @Column(name = "cli_nome")
    private String nome;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cli_cd_cidade", nullable = false)
    private Cidade cidade;
    
    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, mappedBy="cliente")
    private List<Veiculo> veiculo;

    @Column(name = "cli_endereco")
    private String endereco;

    @Column(name = "cli_numero")
    private String numero;

    @Column(name = "cli_complemento")
    private String complemento;

    @Column(name = "cli_bairro")
    private String bairro;

    @Column(name = "cli_cep")
    private String cep;

    @Column(name = "cli_cnpj_cpf")
    private String cpfCnpj;

    @Column(name = "cli_telefone")
    private String telefone;

    @Column(name = "cli_email")
    private String email;

}
