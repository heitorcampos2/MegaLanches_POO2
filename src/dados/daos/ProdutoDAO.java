/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados.daos;

import dados.entidades.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.JPAUtil;

/**
 *
 * @author david
 */
public class ProdutoDAO {
    //salvar o ator no BD
    public void adicionar(Produto a){
         //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();
         //Iniciar a transação
        gerenciador.getTransaction().begin();
        //Remover o ator
        gerenciador.persist(a);
        
        //Commit na transação
        gerenciador.getTransaction().commit();
        
    }
    
     public List<Produto> listar(){
        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();
        
        //criando a consulta no BD
        
        TypedQuery consulta = gerenciador.createQuery
        ("Select a from Produto a", Produto.class);
    
         //retorn a lista de atores
         return consulta.getResultList();
    
    }
}
