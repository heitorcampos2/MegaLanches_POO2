/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.daos.ClienteDAO;
import dados.entidades.Cliente;
import java.util.List;

/**
 *
 * @author david
 */
public class ClienteServico {
     //atributo para representar a camada de dados
    private ClienteDAO dao = new ClienteDAO();
    
    public void adicionar(Cliente a){
        //fazer qualquer regra de negocio
        
        //mandar o ator para a camada de dados
        //para ser salvo no banco de dados
        dao.adicionar(a);
        
    }
    public List<Cliente> listar(){
        //qualquer regra de negocio (se aplicavel)
        //pedir a dao para listar e retornar
        return dao.listar();
    
    }
    
    public void editar(Cliente a){
        //qualquer regra de negocio(se aplicavel)
        
        dao.editar(a);
    
    
    }
    
    public void excluir(Cliente a){
        //qualquer regra de negocio(se aplicavel)
        //mandar para a DAO excluir
        dao.excluir(a);
    
    
    }
}
