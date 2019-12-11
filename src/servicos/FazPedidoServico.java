package servicos;

import dados.daos.FazPedidoDAO;
import dados.entidades.Cliente;
import dados.entidades.PedidoProduto;
import java.util.List;

public class FazPedidoServico {

    //atributo para representar a camada de dados
    private FazPedidoDAO dao = new FazPedidoDAO();

    public void adicionar(PedidoProduto a) {
        //fazer qualquer regra de negocio
        //mandar o pedidoProduto para a camada de dados
        //para ser salvo no banco de dados
        dao.adicionar(a);
    }

    public List<PedidoProduto> listar() {
        //qualquer regra de negocio (se aplicavel)
        //pedir a dao para listar e retornar
        return dao.listar();

    }
     public void excluir(PedidoProduto a) {
        //qualquer regra de negocio(se aplicavel)
        //mandar para a DAO excluir
        dao.excluir(a);

    }
}
