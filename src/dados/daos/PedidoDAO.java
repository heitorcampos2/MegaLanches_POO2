package dados.daos;

import dados.entidades.Pedido;
import javax.persistence.EntityManager;
import util.JPAUtil;

public class PedidoDAO {

    public Pedido adicionar(Pedido a) {
        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();
        //Iniciar a transação
        gerenciador.getTransaction().begin();
        //Remover o pedido
        gerenciador.persist(a);

        //Commit na transação
        gerenciador.getTransaction().commit();

        return a;
    }
}
