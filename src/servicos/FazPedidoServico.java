/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;


import dados.daos.FazPedidoDAO;
import dados.entidades.Cliente;
import dados.entidades.PedidoProduto;
import java.util.List;

/**
 *
 * @author david
 */
public class FazPedidoServico {
     //atributo para representar a camada de dados
    private FazPedidoDAO dao = new FazPedidoDAO();
    
    public void adicionar(PedidoProduto a){
        //fazer qualquer regra de negocio
        
        //mandar o pedidoProduto para a camada de dados
        //para ser salvo no banco de dados
        dao.adicionar(a);
    }
        public List<PedidoProduto> listar(){
        //qualquer regra de negocio (se aplicavel)
        //pedir a dao para listar e retornar
        return dao.listar();
    
    }
    }

    
    
    
    

