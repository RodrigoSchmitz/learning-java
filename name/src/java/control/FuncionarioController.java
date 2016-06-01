/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import model.Funcionario;

/**
 *
 * @author Rodrigo Martins Schmitz
 * Classe controladora de funcionario que irá implementar os métodos de persistencia 
*/

/**
 * 
 * @ManagedBean serve de link  entre as regras de negócio da aplicação com a view
 */
@ManagedBean
public class FuncionarioController {

    @PersistenceUnit (unitName="exemplosPU")
    EntityManagerFactory factory;
    
    Funcionario funcionario;
    
    public void lerFuncionario (Integer id){
        EntityManager em = factory.createEntityManager();
        funcionario = em.find(Funcionario.class, id);
        
    }
}
