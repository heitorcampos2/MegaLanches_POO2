package dados.daos;

import dados.entidades.Pedido;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
    public List<Pedido> listar() {
        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();

        //criando a consulta no BD        
        TypedQuery consulta = gerenciador.createQuery("Select a from Pedido a", Pedido.class);

        //retorn a lista de Pedidos
        return consulta.getResultList();

    }
}
