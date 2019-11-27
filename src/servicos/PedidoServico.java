/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.daos.PedidoDAO;
import dados.entidades.Pedido;

/**
 *
 * @author david
 */
public class PedidoServico {
     private PedidoDAO dao = new PedidoDAO();
     
     public Pedido adicionar(Pedido a){
        //fazer qualquer regra de negocio
        
        //mandar o ator para a camada de dados
        //para ser salvo no banco de dados
        a = dao.adicionar(a);
        return a;
    }
}
