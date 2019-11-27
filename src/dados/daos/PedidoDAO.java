/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados.daos;

import dados.entidades.Pedido;
import javax.persistence.EntityManager;
import util.JPAUtil;

/**
 *
 * @author david
 */
public class PedidoDAO {
     public Pedido adicionar(Pedido a){
         //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();
         //Iniciar a transação
        gerenciador.getTransaction().begin();
        //Remover o ator
        gerenciador.persist(a);
        
        //Commit na transação
        gerenciador.getTransaction().commit();
        
        return a;
    }
}
