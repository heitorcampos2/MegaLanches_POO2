package dados.daos;

import dados.entidades.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.JPAUtil;

public class ClienteDAO {

    //salvar o cliente no BD
    public Cliente adicionar(Cliente a) {
        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();
        //Iniciar a transação
        gerenciador.getTransaction().begin();
        //Remover o cliente
        gerenciador.persist(a);

        //Commit na transação
        gerenciador.getTransaction().commit();

        return a;
    }

    public List<Cliente> listar() {
        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();

        //criando a consulta no BD        
        TypedQuery consulta = gerenciador.createQuery("Select a from Cliente a", Cliente.class);

        //retorn a lista de clientes
        return consulta.getResultList();

    }

    public List<Cliente> listarPeloNomeCliente(String nome) {
        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();

        //criando a consulta no BD        
        TypedQuery<Cliente> consulta = gerenciador.createQuery("Select f from Cliente as f where f.nome like :nome order by f.nome", Cliente.class);

        //substituir o parametro :nome pelo valor da variavel n
        consulta.setParameter("nome", nome + "%");

        //retorn a lista de atores
        return consulta.getResultList();

    }
    // salvar alteração no BD

    public void editar(Cliente a) {
        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();

        //Iniciar a transação
        gerenciador.getTransaction().begin();

        //mandar sincronizar as alterações
        gerenciador.merge(a);
        //Commit
        gerenciador.getTransaction().commit();

    }

    public void excluir(Cliente a) {
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
