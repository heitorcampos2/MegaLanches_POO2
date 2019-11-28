package dados.daos;

import dados.entidades.Cliente;
import dados.entidades.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.JPAUtil;

public class ProdutoDAO {

    //salvar o produto no BD
    public void adicionar(Produto a) {
        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();

        //Iniciar a transação
        gerenciador.getTransaction().begin();

        //Remover o produto
        gerenciador.persist(a);

        //Commit na transação
        gerenciador.getTransaction().commit();
    }

    public List<Produto> listarProdutosNaTabela() {
        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();

        //criando a consulta no BD
        TypedQuery consulta = gerenciador.createQuery("Select a from Produto a", Produto.class);

        //retorn a lista de produtos
        return consulta.getResultList();

    }

    public List<Produto> listarPeloNomeProduto(String nome) {
        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();

        //criando a consulta no BD        
        TypedQuery<Produto> consulta = gerenciador.createQuery("Select f from Produto as f where f.nome_p like :nome_p order by f.nome_p", Produto.class);

        //substituir o parametro :nome pelo valor da variavel n
        consulta.setParameter("nome_p", nome + "%");

        //retorn a lista de produtos
        return consulta.getResultList();
    }

    // salvar alteração no BD
    public void editar(Produto a) {
        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();

        //Iniciar a transação
        gerenciador.getTransaction().begin();

        //mandar sincronizar as alterações
        gerenciador.merge(a);
        //Commit
        gerenciador.getTransaction().commit();
    }

    public void excluir(Produto a) {
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
