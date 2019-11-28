package servicos;

import dados.daos.ProdutoDAO;
import dados.entidades.Cliente;
import dados.entidades.Produto;
import java.util.List;

public class ProdutoServico {
    //atributo para representar a camada de dados

    private ProdutoDAO dao = new ProdutoDAO();

    public void adicionar(Produto a) {
        //fazer qualquer regra de negocio        
        //mandar o produto para a camada de dados
        //para ser salvo no banco de dados
        dao.adicionar(a);

    }

    public List<Produto> listarProdutosNaTabela() {
        //qualquer regra de negocio (se aplicavel)
        //pedir a dao para listar e retornar
        return dao.listarProdutosNaTabela();

    }

    public List<Produto> listarPeloNomeProduto(String nome) {
        //qualquer regra de negocio (se aplicavel)
        //pedir a dao para listar e retornar
        return dao.listarPeloNomeProduto(nome);

    }

    public void editar(Produto a) {
        //qualquer regra de negocio(se aplicavel)
        dao.editar(a);

    }

    public void excluir(Produto a) {
        //qualquer regra de negocio(se aplicavel)
        //mandar para a DAO excluir
        dao.excluir(a);
    }
}
