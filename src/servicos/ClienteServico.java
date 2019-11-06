/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.daos.ClienteDAO;
import dados.entidades.Cliente;

/**
 *
 * @author david
 */
public class ClienteServico {
     //atributo para representar a camada de dados
    private ClienteDAO dao = new ClienteDAO();
    
    public void Adicionar(Cliente a){
        //fazer qualquer regra de negocio
        
        //mandar o ator para a camada de dados
        //para ser salvo no banco de dados
        dao.Adicionar(a);
        
    
    }
    
}
