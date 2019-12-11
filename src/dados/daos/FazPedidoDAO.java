package dados.daos;

import dados.entidades.Cliente;
import dados.entidades.PedidoProduto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.JPAUtil;

public class FazPedidoDAO {

    //salvar o pedido no BD
    public void adicionar(PedidoProduto a) {

        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();

        //Iniciar a transação
        gerenciador.getTransaction().begin();

        //Remover o pedido
        gerenciador.persist(a);

        //Commit na transação
        gerenciador.getTransaction().commit();
    }

    public List<PedidoProduto> listar() {
        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();

        //criando a consulta no BD        
        TypedQuery consulta = gerenciador.createQuery("Select a from PedidoProduto a", PedidoProduto.class);

        //retorna a lista de pedidos
        return consulta.getResultList();

    }
    
     public void excluir(PedidoProduto a) {
        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();

        //Iniciar a transação
        gerenciador.getTransaction().begin();

        //mandar sincronizar as alterações
        a = gerenciador.merge(a);

        //mandar sincronizar as alteracoes
        gerenciador.remove(a);
        //Commit
        gerenciador.getTransaction().commit();

    }

}
