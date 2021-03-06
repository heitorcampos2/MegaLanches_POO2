package servicos;

import dados.daos.ClienteDAO;
import dados.entidades.Cliente;
import java.util.List;

public class ClienteServico {
    //atributo para representar a camada de dados

    private ClienteDAO dao = new ClienteDAO();

    public Cliente adicionar(Cliente a) {
        //fazer qualquer regra de negocio        
        //mandar o cliente para a camada de dados
        //para ser salvo no banco de dados
        dao.adicionar(a);
        return a;
    }

    public List<Cliente> listar() {
        //qualquer regra de negocio (se aplicavel)
        //pedir a dao para listar e retornar
        return dao.listar();

    }

    public List<Cliente> listarPeloNomeCliente(String nome) {
        //qualquer regra de negocio (se aplicavel)
        //pedir a dao para listar e retornar
        return dao.listarPeloNomeCliente(nome);

    }

    public void editar(Cliente a) {
        //qualquer regra de negocio(se aplicavel)        
        dao.editar(a);
    }

    public void excluir(Cliente a) {
        //qualquer regra de negocio(se aplicavel)
        //mandar para a DAO excluir
        dao.excluir(a);

    }
}
