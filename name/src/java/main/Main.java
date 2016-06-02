/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import model.Funcionario;

/**
 *
 * @author Rodrigo Martins Schmitz
 * @EntityManager é responsável por realizar ações de persistencia na db, ela é uma interface portanto não pode ser instanciada ela é obtida por uma EntityManagerFactory
 * @EntityTransaction abre o escopo de transação em um EntityManager 
 */
public class Main {
    public static void main(String[] args) throws Exception{
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("funcionarioPU");
        EntityManager eManager = emFactory.createEntityManager();
        EntityTransaction tx = eManager.getTransaction();
        
        try {
            tx.begin();
            Funcionario f = eManager.find(Funcionario.class, new Integer(5));
            System.out.println(f);
            f.setNome(f.getNome() + "Da Silva");
            tx.commit();
        } catch (Exception e) {
            if(tx.isActive()){
                tx.rollback();
            }
        }
        eManager.close();
        emFactory.close();
    }
}
