package servicos;

import dados.daos.PedidoDAO;
import dados.entidades.Pedido;
import java.util.List;

public class PedidoServico {

    private PedidoDAO dao = new PedidoDAO();

    public Pedido adicionar(Pedido a) {
        //fazer qualquer regra de negocio        
        //mandar o pedido para a camada de dados
        //para ser salvo no banco de dados
        a = dao.adicionar(a);
        return a;
    }
    
    public List<Pedido> listar() {
        //qualquer regra de negocio (se aplicavel)
        //pedir a dao para listar e retornar
        return dao.listar();

    }
}
