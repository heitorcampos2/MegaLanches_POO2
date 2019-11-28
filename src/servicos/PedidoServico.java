package servicos;

import dados.daos.PedidoDAO;
import dados.entidades.Pedido;

public class PedidoServico {

    private PedidoDAO dao = new PedidoDAO();

    public Pedido adicionar(Pedido a) {
        //fazer qualquer regra de negocio        
        //mandar o pedido para a camada de dados
        //para ser salvo no banco de dados
        a = dao.adicionar(a);
        return a;
    }
}
