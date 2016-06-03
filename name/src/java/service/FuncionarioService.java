/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Funcionario;

/**
 *
 * @author Rodrigo Martins Schmitz
 */
@Stateless
public class FuncionarioService {
    
    @PersistenceContext
    EntityManager em;
    
    public List<Funcionario> listAll() {
        Query query = em.createNamedQuery("Funcionario.listAll");
        return query.getResultList();
    }
    
    public List<Funcionario> listByParams(final String nome) {
        StringBuilder strQuery = new StringBuilder();
        
        strQuery.append("SELECT f FROM Funcionario f");
        strQuery.append(" WHERE f.id IS NOT NULL");
        
        if (nome != null && !nome.equals("")) {
            strQuery.append(" AND f.nome like '%").append(nome).append("%'");
        }
        
        strQuery.append(" ORDER BY f.nome");
        
        Query query = em.createQuery(strQuery.toString());
        
        return query.getResultList();
    }
    
    public Funcionario find(final Integer id) {
        return em.find(Funcionario.class, id);
    }
    
    public Funcionario insert(final Funcionario funcionario) {
        em.persist(funcionario);
        em.flush();
        return funcionario;
    }
    
    public Funcionario update(final Funcionario funcionario) {
        em.merge(funcionario);
        em.flush();
        return funcionario;
    }
    
    public Funcionario remove(final Integer id) {
        Funcionario funcionario = this.find(id);
        em.remove(funcionario);
        em.flush();
        return funcionario;
    }

}
