/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Rodrigo Martins Schmitz
 */
class Endereco {
    
    private String rua;
    private Funcionario funcionario;

    public Endereco(String rua) {
        this.rua = rua;
    }

    public Endereco() {
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
    
    

}
