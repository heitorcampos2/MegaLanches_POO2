/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.fazPedido;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dados.dto.ProdutoPedido;
import dados.entidades.Cliente;
import dados.entidades.Pedido;
import dados.entidades.PedidoProduto;
import dados.entidades.Produto;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import servicos.ClienteServico;
import servicos.FazPedidoServico;
import servicos.PedidoServico;
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
    
    private ObservableList<Cliente> dados = FXCollections.observableArrayList();
    
     private Produto ProdutoSelecionado;
     private Cliente clienteSelecionado;
    @FXML
    private TableColumn colId;
    @FXML
    private TableColumn colNome;
    @FXML
    private JFXTextField textFieldPesquisarProduto;
    @FXML
    private TableView<Produto> tabelaDisponiveis;
   
   
    private ObservableList<Produto> dados_p = FXCollections.observableArrayList();
     
    
    //SERVIÇOS
     //Atributo para representar o servico
    private FazPedidoServico FazPedidoservico = new FazPedidoServico();
    private ClienteServico ClienteServico = new ClienteServico();
    private ProdutoServico ProdutoServico = new ProdutoServico();
    private PedidoServico PedidoServico = new PedidoServico();
    @FXML
    private TableColumn colProduto;
    @FXML
    private TableColumn colPreco;
    @FXML
    private TableView tabelaSelecionados;
    @FXML
    private TabPane tabPaneFazPedido;
    @FXML
    private Tab tabCliente;
    @FXML
    private Tab TabProduto;
    @FXML
    private Tab tabResumo;
    @FXML
    private TableColumn colProdutoSelecionado;
    @FXML
    private TableColumn colPrecoSelecionado;
    @FXML
    private TableColumn colQtdSelecionado;
    @FXML
    private JFXTextField TextFieldeClienteResumo;
    
    private List<PedidoProduto> Temp = new ArrayList<PedidoProduto>();
    @FXML
    private Spinner<Integer> spinnerQuantidade;
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
    
        spinnerQuantidade.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100));
    } 
    //#########mensagens#####
    
    //mensagem sucesso
    public void mensagemSucesso(String m ){
        
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Sucesso!"); //título
        alerta.setHeaderText(null); //cabeçalho (opcional)
        alerta.setContentText(m);// conteudo
        alerta.showAndWait(); //mostrando o alerta
    }
 
 //exibe uma mensagem de erro
    public void mensagemErro(String m){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("SUCESSO!"); 
        alerta.setHeaderText(null); 
        alerta.setContentText(m);
        alerta.showAndWait(); 
    }
    
    //exibe uma mensagem de confirmação
    private Optional<ButtonType> mensagemDeConfirmacao(String mensagem, String titulo){
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle(titulo); 
        alerta.setHeaderText(null); 
        alerta.setContentText(mensagem);
        
        return alerta.showAndWait();
    }
    //#####ConfigurarTabela
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
        
    }//configurarTabelaDisponiveis
    
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

    @FXML
    private void SelecionarCliente(ActionEvent event) {
       
        
         // pegar o Cliente que foi selecionado na tabela
        clienteSelecionado = tabela.getSelectionModel().getSelectedItem();
        
         if(clienteSelecionado!= null){//existe cliente selecionado
            
           
               SelectionModel<Tab> sm = tabPaneFazPedido.getSelectionModel();
        sm.select(TabProduto);
          
    
           }else{
             mensagemErro("Selecione um Cliente.");
         
         }
           
        TextFieldeClienteResumo.setText( clienteSelecionado.getNome());
        
    }

    @FXML
    private void AvancarResumo(ActionEvent event) {
        
        
        
        ProdutoSelecionado = tabelaDisponiveis.getSelectionModel().getSelectedItem();
        if(ProdutoSelecionado!= null){//existe cliente selecionado
            
           
               SelectionModel<Tab> sm = tabPaneFazPedido.getSelectionModel();
            sm.select(tabResumo);
          
    
           }else{
             mensagemErro("Selecione um Produto.");
         
         }
    }

    @FXML
    private void AdcionarNoPedido(ActionEvent event) {
        
        //Pegar o produto selecionado
        ProdutoSelecionado = tabelaDisponiveis.getSelectionModel().getSelectedItem();
        if(ProdutoSelecionado!= null){//existe Produto selecionado
            
          BigDecimal preco = ProdutoSelecionado.getPreco_un();
          Integer quantidade = spinnerQuantidade.getValue();
          
         //
          PedidoProduto p = new PedidoProduto();
          p.setPreco(preco);
          p.setQtd(quantidade);
          p.setProduto(ProdutoSelecionado);
          
          //Armazenando na lista
          Temp.add(p);
          
           
          
    
           }else{
             mensagemErro("Selecione um Produto.");
         
         }
    }

    @FXML
    private void excluirDoPedido(ActionEvent event) {
    }

    @FXML
    private void FinalizarPedido(ActionEvent event) {
        
        Pedido pedido = new Pedido(LocalDateTime.now(), clienteSelecionado);
        
        pedido = PedidoServico.adicionar(pedido);
        
        
        
        System.out.println(pedido.getId_pedido());
        
        //Para cada produto na lista temporaria
        //inserir um pedido produto
        for(PedidoProduto pp : Temp){
            
            //Associando o pp ao pedido
            pp.setPedido(pedido);
            //Mandar o servico salvar
            FazPedidoservico.adicionar(pp);
            
        }
        
    }
}
        
        
    

    

