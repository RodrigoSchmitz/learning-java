/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author Rodrigo Martins Schmitz
 */
class Endereco {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_endereco")
    private Integer id;
    
    @Column (name = "nm_rua")
    private String rua;
    
   /**
    *@mappedBy estabelece o relacionamento, usamos na classe nao proprietaria do relacionamento
    */
    @OneToOne (mappedBy = "endereco")
    private Funcionario funcionario;

    public Endereco(Integer id, String rua, Funcionario funcionario) {
        this.id = id;
        this.rua = rua;
        this.funcionario = funcionario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
}
