/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.cadastroProduto;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import dados.entidades.Produto;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import servicos.ProdutoServico;

/**
 * FXML Controller class
 *
 * @author david
 */
public class CadastroProdutoController implements Initializable {

    @FXML
    private JFXTextField TextFieldNomeProduto;
    @FXML
    private JFXTextField TextFieldPrecoProduto;
    @FXML
    private JFXTextArea TextAreaIngredientes;
    @FXML
    private JFXTextField TextFieldID;
    //Atributo para representar o servico
    private ProdutoServico servico = new ProdutoServico();
    @FXML
    private TableView<Produto> tabela;
    @FXML
    private TableColumn colId;
    @FXML
    private TableColumn colProduto;
    @FXML
    private TableColumn colValor;
    @FXML
    private TableColumn colIngredientes;
    
    //atributo que representa os dados para a tabela
    private ObservableList<Produto> dados = 
            FXCollections.observableArrayList();
    //criando um atributo que vai armazenar o ator que foi selecionado na tabela
    private Produto selecionado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
        //configurar tabela
        configurarTabela();
        //carregar a lista de atores na tabela
        listarProdutosNaTabela();
    
    }    
    
    

    @FXML
    private void adicionar(ActionEvent event) {
         //pegando os dados do formulario
        Produto a = new Produto (TextFieldNomeProduto.getText(),
                  new BigDecimal (TextFieldPrecoProduto.getText()),TextAreaIngredientes.getText());
        
        //mandar o Produto para a camada de servicos
        
        servico.adicionar(a);
        
        //Exibindo mensagem
        mensagem("Produto salvo com sucesso!");
        
        //chama o metodo para atualizar a tabela
        listarProdutosNaTabela();
        
        //Limpando o form
        
       TextFieldNomeProduto.setText("");
       TextFieldPrecoProduto.setText("");
       TextAreaIngredientes.setText("");
    }
 public void mensagem(String m ){
        
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Sucesso!"); //título
        alerta.setHeaderText(null); //cabeçalho (opcional)
        alerta.setContentText(m);// conteudo
        alerta.showAndWait(); //mostrando o alerta
    
    
    }
 
 //fazendo configuração das colunas da tabela
    private void configurarTabela(){
        //dixer onde a coluna vai pegar o valor para
        //exibir, basta dizer o nome do metodo get que 
        //deve ser chamado para cada coluna
        //a String entre parenteses e o nome do 
       //atributo que vc deseja chamar o get (qause sempre)
        
        colId.setCellValueFactory(new PropertyValueFactory("id_produto"));
        colProduto.setCellValueFactory(new PropertyValueFactory("nome_p"));
        colValor.setCellValueFactory(new PropertyValueFactory("preco_un"));
        colIngredientes.setCellValueFactory(new PropertyValueFactory("ingredientes"));
        
    }//configurarTabela
        
    //responsavel por carregar a lista de atores na tabela
        private void listarProdutosNaTabela(){
        
        //limpar quaisquer dados anteriores
        
        dados.clear();
        //solicitando a camada de servoços a lista de atores
        List<Produto> Produto = servico.listar();
        
        //transformar a lista de atores no formato que a tabela
        //do javaFX aceita
        dados = FXCollections.observableArrayList(Produto);
        //jogando os dados na tabela
        
        tabela.setItems(dados);
 
        }
 
    @FXML
    private void editar(ActionEvent event) {
    }

    @FXML
    private void excluir(ActionEvent event) {
    }
    
}
