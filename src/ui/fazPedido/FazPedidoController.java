/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.fazPedido;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dados.entidades.Cliente;
import dados.entidades.Produto;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import servicos.ClienteServico;
import servicos.FazPedidoServico;
import servicos.ProdutoServico;

/**
 * FXML Controller class
 *
 * @author HeiThor
 */
public class FazPedidoController implements Initializable {

    @FXML
    private JFXTextField textFieldPesquisar;
    @FXML
    private TableView<Cliente> tabela;
 //Atributo para representar o servico
    private FazPedidoServico servico = new FazPedidoServico();
    private ClienteServico ClienteServico = new ClienteServico();
    //private ClienteServico ProdutoServico = new ProdutoServico();
    private ObservableList<Cliente> dados = FXCollections.observableArrayList();
    //criando um atributo que vai armazenar o Cliente que foi selecionado na tabela
     private Cliente selecionado;
    @FXML
    private TableColumn colId;
    @FXML
    private TableColumn colNome;
    @FXML
    private JFXTextField textFieldPesquisarProduto;
    @FXML
    private TableView<Produto> tabelaDisponiveis;
    //Atributo para representar o servico
    private ProdutoServico ProdutoServico = new ProdutoServico();
    //private ProdutoServico ProdutoServico = new ProdutoServico();
    private ObservableList<Produto> dados_p = FXCollections.observableArrayList();
    //criando um atributo que vai armazenar o Cliente que foi selecionado na tabela
    @FXML
    private TableColumn colProduto;
    @FXML
    private TableColumn colPreco;
    @FXML
    private TableView tabelaSelecionados;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //configurar tabela
        configurarTabela();
        //carregar a lista de Clientes na tabela
        listarClientesNaTabela();
        listarProdutosNaTabela();        
    
    }    
    private void configurarTabela(){
        //dixer onde a coluna vai pegar o valor para
        //exibir, basta dizer o nome do metodo get que 
        //deve ser chamado para cada coluna
        //a String entre parenteses e o nome do 
       //atributo que vc deseja chamar o get (qause sempre)
        
        colId.setCellValueFactory(new PropertyValueFactory("id_cliente"));
        colNome.setCellValueFactory(new PropertyValueFactory("nome"));
        
        colProduto.setCellValueFactory(new PropertyValueFactory("nome_p"));//*
        colPreco.setCellValueFactory(new PropertyValueFactory("preco_un"));
        
    }//configurarTabela
    
     private void listarClientesNaTabela(){
        
        //limpar quaisquer dados anteriores
        
        dados.clear();
        //solicitando a camada de servoços a lista de Clientes
        List<Cliente> Cliente = ClienteServico.listar();
        
        //transformar a lista de Clientes no formato que a tabela
        //do javaFX aceita
        dados = FXCollections.observableArrayList(Cliente);
        //jogando os dados na tabela
        
        tabela.setItems(dados);
 
        }
     
      private void listarProdutosNaTabela() {
        //limpar quaisquer dados anteriores
        
        dados_p.clear();
        //pegar nome da pessoa q deseja pesquisar
        String nome = textFieldPesquisarProduto.getText();
        
        //solicitando a camada de serviços a lista de Produto
        List<Produto> Produto = ProdutoServico.listarProdutosNaTabela();
        
        //transformar a lista de Produtos no formato que a tabela
        //do javaFX aceita
        dados_p  = FXCollections.observableArrayList(Produto);
        //jogando os dados na tabela
        
        tabelaDisponiveis.setItems(dados_p);
    }

    @FXML
    private void PesquisarProduto(ActionEvent event) {
        
        //limpar quaisquer dados anteriores        
        dados_p.clear();
        //pegar nome da pessoa q deseja pesquisar
        String nome = textFieldPesquisarProduto.getText();
        
        //solicitando a camada de serviços a lista de Clientes
        List<Produto> Produto = ProdutoServico.listarPeloNomeProduto(nome);
        
        //transformar a lista de Clientes no formato que a tabela
        //do javaFX aceita
        dados_p  = FXCollections.observableArrayList(Produto);
        //jogando os dados na tabela
        
        tabelaDisponiveis.setItems(dados_p);
    }

    @FXML
    private void PesquisarCliente(ActionEvent event) {
        
        //limpar quaisquer dados anteriores        
        dados.clear();
        //pegar nome da pessoa q deseja pesquisar
        String nome = textFieldPesquisar.getText();
        
        //solicitando a camada de serviços a lista de Clientes
        List<Cliente> Cliente = ClienteServico.listarPeloNomeCliente(nome);
        
        //transformar a lista de Clientes no formato que a tabela
        //do javaFX aceita
        dados = FXCollections.observableArrayList(Cliente);
        //jogando os dados na tabela
        
        tabela.setItems(dados);
    }
}
        
        
    

    

