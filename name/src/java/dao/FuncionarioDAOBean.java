/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Funcionario;

/**
 *
 * @author Rodrigo Martins Schmitz
 * @Stateless ele não guarda o estado dos objetos, trata cada requisicao como uma nova requisicao
 */
@Stateless
public class FuncionarioDAOBean {
    @PersistenceContext (unitName="funcionarioPU")
    EntityManager eManager;
    
    /**
     * Metodo que busca e retorna um funcionario pelo id dele
     * @param id
     * @return Um Funcionario
     * @throws Exception de id invalido
     * eManager.find(Classe, Parametro) e o metodo que busca um funcionario usando EntityManager
     */
    public Funcionario recuperarById(Integer id) throws Exception{
        if(id == null || id.intValue() <= 0){
            throw new Exception("Identificador invalido: " + id);
        }
        Funcionario f = eManager.find(Funcionario.class, id);
        return f;
    }
    
    /**
     * Metodo que salva um novo funcionario e retorno o id dele
     * @param f Funcionario
     * @return id
     * @throws Exception de funcionario invalido
     * eManager.persist(Objeto) ele insere a entidade em cache e prepara o insert na db
     * eManager.flush() ele sincroniza o cache com a db
     */
    public Integer salvar (Funcionario f) throws Exception{
        if(f == null || f.getMatricula() == 0 || f.getId() != null){
        throw new Exception("Funcionario invalido");
        }
        eManager.persist(f);
        eManager.flush();
        return f.getId();
    }
    
    /**
     * Metodo que atualiza um funcionario já existente
     * @param f Funcioanario
     * @throws Exception de funcionario invalido
     * eManager.merge(Objeto) cria uma copia e atualiza o valor da entidade e prepara uma operacao de update na db
     */
    public void atualizar (Funcionario f) throws Exception{
        if(f == null || f.getMatricula() == 0 || f.getId() == null){
            throw new Exception("Funcionario invalido");
        }
        eManager.merge(f);
        eManager.flush();
    }
    
    /**
     * Metodo que remove um funcionario existente pelo id do mesmo
     * @param id
     * @return Funcionario
     * @throws Exception Funcioanrio inexistente
     * eManager.remove(Objeto) remove a instancia da ntidade e prepara uma operacao de delete na db
     */
    public Funcionario removeById (Integer id) throws Exception{
        Funcionario f = recuperarById(id);
        if(f == null) {
            throw new Exception("Funcionario inexistente para remocao");
        }
        eManager.remove(f);
        eManager.flush();
        return f;
    }

}  
