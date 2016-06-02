/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Rodrigo Martins Schmitz
 * Este é uma classe de estudo na parte de persistencia de java
 * Serializable indica que os atributos podem ser serializados onde cada atributo se relaciona ou não a uma coluna da tabela de banco de dados
 */
public class Funcionario implements Serializable {
    /**
     * @Id indica que o atributo abaixo equivale ao ID da databse 
     * @GeneratedValue indica que do atributo vai ser gerado seguindo um padrão do tipo identidade
     * @Column indica a qual coluna o atributo refere-se se omitido o campo será marcado como default o proprio nome do atributo
     * Nesse caso esse atributo se liga na coluna da tabela id_funcionario onde a estrategia que gera os valores e do tipo identidade
     */
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name="id_funcionario")
    private Integer id;
    
    /**
     * O atributo nome se liga a coluna tx_nome da tabela que não pode ser nulo
     * nullable é a posibilidade de uma coluna da tabela ser nula ou não, por default é marcado como true
     */
    @Column (name="tx_nome", nullable=false)
    private String nome;
    
    /**
     * @transient marca quando um atributo não faz parte das oprações de persistencia
     */
    @Transient
    private Endereco endereco;
    
    /**
     * O atributo ramal se liga a coluna nr_ramal da tabela
     */
    @Column (name="nr_ramal")
    private short ramal;
    
    /**
     * O atributo matricula se liga a coluna nr_matricula e não pode ser nulo
     */
    @Column (name="nr_matricula", nullable=false)
    private int matricula;
    
    /**
     * @Temporal indica que o campo da tabela armazena um tipo relacionado com o tempo
     * O atributo admissao se liga a coluna dt_admissao do tipo Date que não pode ser nulo
     */
    @Temporal (TemporalType.DATE)
    @Column (name="dt_admissao", nullable=false)
    private Date admissao;

    public Funcionario(Integer id, String nome, Endereco endereco, short ramal, int matricula, Date admissao) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.ramal = ramal;
        this.matricula = matricula;
        this.admissao = admissao;
    }

    public Funcionario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public short getRamal() {
        return ramal;
    }

    public void setRamal(short ramal) {
        this.ramal = ramal;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Date getAdmissao() {
        return admissao;
    }

    public void setAdmissao(Date admissao) {
        this.admissao = admissao;
    }

}
