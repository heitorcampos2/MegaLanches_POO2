/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author david
 */
public class JPAUtil {
    
     private static EntityManagerFactory fabrica = Persistence.
            createEntityManagerFactory("lanchonete");
    
    public static EntityManager getGerenciador (){
        return fabrica.createEntityManager(); 
    }   
}
