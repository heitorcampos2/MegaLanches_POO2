package dados.daos;

import dados.entidades.Pedido;
import dados.entidades.PedidoProduto;
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
    
    public void excluir(Pedido a) {
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
    
     public List<PedidoProduto> detalhar(Pedido p) {
        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();

        //criando a consulta no BD        //Select produto,preco,qtd from pedido where pedido == p
        TypedQuery<PedidoProduto> consulta = gerenciador.createQuery("Select pp from PedidoProduto pp JOIN pp.pedido WHERE pp.pedido = :pedido", PedidoProduto.class);

        //substituir o parametro :Pedido pelo valor da variavel pedido
        consulta.setParameter("pedido", p);

        //retorn a lista de atores
        return consulta.getResultList();

    }
}
